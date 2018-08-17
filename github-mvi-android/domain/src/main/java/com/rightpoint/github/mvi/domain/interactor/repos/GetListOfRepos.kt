package com.rightpoint.github.mvi.domain.interactor.repos

import com.rightpoint.github.mvi.domain.interactor.FlowableUseCase
import com.rightpoint.github.mvi.domain.model.RepoModel
import com.rightpoint.github.mvi.domain.repository.repo.RepoRepository
import io.reactivex.Flowable
import javax.inject.Inject

class GetListOfRepos @Inject constructor(
    private val repository: RepoRepository
) : FlowableUseCase<GetListOfRepos.Params, List<RepoModel>>() {
    override fun execute(params: Params?): Flowable<List<RepoModel>> {
        val verified = requireNotNull(params) {
            "The parameters to get a list of repos by organization cannot be null!"
        }

        return repository.getListOfReposByOrg(verified.org)
    }

    data class Params(val org: String)
}