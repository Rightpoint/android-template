package com.rightpoint.github.mvi.repos

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.jakewharton.rxrelay2.PublishRelay
import com.rightpoint.github.mvi.R
import com.rightpoint.github.mvi.common.list.BaseAdapter
import com.rightpoint.github.mvi.common.list.Item
import com.uber.autodispose.android.lifecycle.scope
import com.uber.autodispose.kotlin.autoDisposable
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.Collections
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), Consumer<State> {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel
    private val adapter = BaseAdapter<Item>()
    private val intents = PublishRelay.create<Intent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, factory)[MainViewModel::class.java]

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        repos.layoutManager = LinearLayoutManager(this)
        repos.adapter = adapter
        repos.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    override fun onResume() {
        super.onResume()
        intents.compose(viewModel.model())
            .doOnDispose { Timber.i("This is being disposed") }
            .autoDisposable(lifecycle.scope())
            .subscribe(this::accept, Timber::e)
        intents.accept(Intent("Raizlabs"))
    }

    override fun accept(state: State) {
        Timber.i("State: %s", state.toString())
        when (state) {
            is State.Loaded -> adapter.submitList(state.data)
            else -> {
                val item = StateItem(
                    state = state,
                    onRetry = {
                        intents.accept(Intent("Raizlabs"))
                    }
                )
                val singletonList = Collections.singletonList<Item>(item)
                adapter.submitList(singletonList)
            }
        }
    }
}