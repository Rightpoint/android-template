package com.rightpoint.mvi.example.commit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jakewharton.rxrelay2.PublishRelay
import com.rightpoint.common.exhaustive
import com.rightpoint.mvi.example.GlideApp
import com.rightpoint.mvi.example.R
import com.uber.autodispose.android.lifecycle.scope
import com.uber.autodispose.kotlin.autoDisposable
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.layout_latest_commit.*
import timber.log.Timber
import javax.inject.Inject

class CommitBottomSheetDialog : BottomSheetDialogFragment(), Consumer<State> {
    private val actions = PublishRelay.create<Action>()

    @Inject lateinit var viewModel: CommitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        actions.compose(viewModel.model())
            .observeOn(AndroidSchedulers.mainThread())
            .autoDisposable(lifecycle.scope())
            .subscribe(this, Consumer { t -> Timber.e(t) })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_latest_commit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val owner = requireNotNull(arguments).getString(EXTRA_OWNER)!!
        val repo = requireNotNull(arguments).getString(EXTRA_REPO)!!

        actions.accept(Action.LoadListOfCommits(owner, repo))
    }

    override fun accept(state: State) {
        when (state) {
            State.Loading -> {
            }
            is State.Loaded -> renderCommit(state.item)
            State.Empty -> {
            }
            is State.Error -> {
            }
        }.exhaustive
    }

    private fun renderCommit(item: CommitItem) {
        commitMessage?.text = item.message

        committerAvatar?.let { avatar ->
            val radiusInPixels = resources
                .getDimensionPixelSize(R.dimen.avatar_corner_radius)

            GlideApp.with(this)
                .load(item.authorAvatarUrl)
                .transform(RoundedCorners(radiusInPixels))
                .into(avatar)

            avatar.setOnClickListener {
                CustomTabsIntent.Builder()
                    .addDefaultShareMenuItem()
                    .build()
                    .launchUrl(requireContext(), item.authorHtmlUrl.toUri())
            }
        }

        committerInfo?.text = item.authorLogin
    }

    companion object {
        private const val EXTRA_OWNER = "extra:owner"
        private const val EXTRA_REPO = "extra:repo"

        @JvmStatic
        fun newInstance(owner: String, repo: String): CommitBottomSheetDialog {
            return CommitBottomSheetDialog().apply {
                arguments = bundleOf(
                    EXTRA_OWNER to owner,
                    EXTRA_REPO to repo
                )
            }
        }
    }
}