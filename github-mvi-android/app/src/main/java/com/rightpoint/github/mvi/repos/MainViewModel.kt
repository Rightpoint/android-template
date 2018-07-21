package com.rightpoint.github.mvi.repos

import android.arch.lifecycle.ViewModel
import com.rightpoint.github.mvi.domain.interactor.repos.GetListOfRepos
import com.rightpoint.github.mvi.domain.model.RepoModel
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getListOfRepos: GetListOfRepos
) : ViewModel() {

    fun model(): ObservableTransformer<Intent, State> {
        return ObservableTransformer { upstream ->
            upstream.flatMap(this::getListOfRepos)
        }
    }

    private fun getListOfRepos(intent: Intent): Observable<State> {
        Timber.i("Intent: %s", intent)
        return getListOfRepos.execute(GetListOfRepos.Params(intent.owner))
            .toObservable()
            .map(this::mapToViewModel)
            .map<State>(State::Loaded)
            .onErrorReturn(State::Error)
            .startWith(State.Loading)
    }

    private fun mapToViewModel(models: List<RepoModel>): List<RepoItem> {
        val viewModels = mutableListOf<RepoItem>()
        for (model in models) {
            viewModels.add(
                RepoItem(
                    id = model.id,
                    name = model.name,
                    description = model.description,
                    ownerAvatarUrl = model.owner.avatarUrl,
                    forks = model.forksCount,
                    stars = model.stargazersCount,
                    watchers = model.watchersCount
                )
            )
        }
        return viewModels
    }
}