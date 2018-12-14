package com.rightpoint.mvi.example.domain.interactor.repo

import com.rightpoint.mvi.example.domain.interactor.FlowableUseCase
import com.rightpoint.mvi.example.domain.model.RepoModel
import com.rightpoint.mvi.example.domain.repository.repo.RepoRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetListOfRepos @Inject constructor(
    private val repository: RepoRepository
) : FlowableUseCase<GetListOfRepos.Params, List<RepoModel>>() {
    override fun execute(params: Params): Flowable<List<RepoModel>> {
        return repository.getListOfReposByOrg(params.org)
    }

    data class Params(val org: String)
}