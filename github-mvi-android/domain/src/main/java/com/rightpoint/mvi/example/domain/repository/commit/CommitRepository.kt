package com.rightpoint.mvi.example.domain.repository.commit

import com.rightpoint.mvi.example.domain.model.CommitModel
import io.reactivex.Single

interface CommitRepository {
    fun getListOfCommitsByRepo(owner: String, repo: String): Single<List<CommitModel>>
}