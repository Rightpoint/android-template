package com.rightpoint.mvi.example.commit

import androidx.lifecycle.ViewModel
import com.rightpoint.common.exhaustive
import com.rightpoint.mvi.example.domain.interactor.commit.GetListOfCommits
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class CommitViewModel @Inject constructor(
    private val getListOfCommits: GetListOfCommits
) : ViewModel() {
    fun model(): ObservableTransformer<Action, State> {
        return ObservableTransformer { upstream ->
            upstream.flatMap { action ->
                when (action) {
                    is Action.LoadListOfCommits -> getLatestCommit(action)
                }.exhaustive
            }
        }
    }

    private fun getLatestCommit(action: Action.LoadListOfCommits): Observable<State> {
        val params = GetListOfCommits.Params(action.owner, action.repo)
        return getListOfCommits(params)
            .toObservable()
            .map { list ->
                list.map { model ->
                    CommitItem(
                        sha = model.sha,
                        message = model.message,
                        commentCount = model.commentCount,
                        url = model.url,
                        htmlUrl = model.htmlUrl,
                        commentsUrl = model.commentsUrl,
                        authorLogin = model.author?.login ?: "",
                        authorId = model.author?.id ?: -1,
                        authorAvatarUrl = model.author?.avatarUrl ?: "",
                        authorUrl = model.author?.url ?: "",
                        authorHtmlUrl = model.author?.htmlUrl ?: ""
                    )
                }
            }
            .map { it.first() }
            .map<State>(State::Loaded)
            .onErrorReturn(State::Error)
            .startWith(State.Loading)
    }
}