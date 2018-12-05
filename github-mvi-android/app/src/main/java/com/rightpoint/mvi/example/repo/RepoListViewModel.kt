package com.rightpoint.mvi.example.repo

import androidx.lifecycle.ViewModel
import com.rightpoint.common.exhaustive
import com.rightpoint.mvi.example.domain.interactor.repo.GetListOfRepos
import com.rightpoint.mvi.example.repo.model.RepoItemMapper
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class RepoListViewModel @Inject constructor(
    private val getListOfRepos: GetListOfRepos,
    private val itemMapper: RepoItemMapper
) : ViewModel() {
    fun model(): ObservableTransformer<Action, State> {
        return ObservableTransformer { upstream ->
            upstream.flatMap { action ->
                when (action) {
                    is Action.LoadListOfRepos -> getListOfReposByOrganization(action)
                }.exhaustive
            }
        }
    }

    private fun getListOfReposByOrganization(action: Action.LoadListOfRepos): Observable<State> {
        val params = GetListOfRepos.Params(action.organization)
        return getListOfRepos(params)
            .toObservable()
            .map { it.map(itemMapper::map) }
            .map { list ->
                if (list.isEmpty()) {
                    State.Empty
                } else {
                    State.Loaded(list)
                }
            }
            .onErrorReturn(State::Error)
            .startWith(State.Loading)
    }
}