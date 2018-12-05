package com.rightpoint.mvi.example.repo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.jakewharton.rxrelay2.PublishRelay
import com.rightpoint.common.android.list.BaseAdapter
import com.rightpoint.common.android.list.Item
import com.rightpoint.common.exhaustive
import com.rightpoint.mvi.example.R
import com.rightpoint.mvi.example.commit.CommitBottomSheetDialog
import com.uber.autodispose.android.lifecycle.scope
import com.uber.autodispose.kotlin.autoDisposable
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_repo_list_loading.*
import timber.log.Timber
import javax.inject.Inject

class RepoListFragment : DaggerFragment(), Consumer<State> {
    private val actions = PublishRelay.create<Action>()
    private val adapter = BaseAdapter<Item>()

    @Inject lateinit var viewModel: RepoListViewModel

    val onCommitClick = { name: String ->
        CommitBottomSheetDialog.newInstance("Raizlabs", name)
            .show(childFragmentManager, "Commit")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actions.compose(viewModel.model())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .autoDisposable(lifecycle.scope())
            .subscribe(this, Consumer { Timber.e(it) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repo_list_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootLayout.loadLayoutDescription(R.xml.repo_list_layout_states)
        setUpRecyclerView()
        actions.accept(Action.LoadListOfRepos("Raizlabs"))
    }

    private fun setUpRecyclerView() {
        repoList.layoutManager = GridLayoutManager(requireContext(), 2)
        repoList.adapter = adapter
    }

    override fun accept(state: State) {
        when (state) {
            State.Loading -> {
                rootLayout?.setState(R.id.loading, 0, 0)
            }
            is State.Loaded -> {
                adapter.submitList(state.data)
                rootLayout?.setState(R.id.content, 0, 0)
            }
            State.Empty -> {
                // TODO: handle the empty state
            }
            is State.Error -> {
                // TODO: handle the error state
            }
        }.exhaustive
    }
}