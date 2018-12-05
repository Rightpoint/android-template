package com.rightpoint.mvi.example.domain.interactor.commit

import com.rightpoint.mvi.example.domain.interactor.SingleUseCase
import com.rightpoint.mvi.example.domain.model.CommitModel
import com.rightpoint.mvi.example.domain.repository.commit.CommitRepository
import io.reactivex.Single
import javax.inject.Inject

class GetListOfCommits @Inject constructor(
    private val repository: CommitRepository
) : SingleUseCase<GetListOfCommits.Params, List<CommitModel>>() {
    override fun execute(params: Params): Single<List<CommitModel>> {
        return repository.getListOfCommitsByRepo(params.owner, params.repo)
    }

    data class Params(val owner: String, val repo: String)
}