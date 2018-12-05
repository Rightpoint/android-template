package com.rightpoint.mvi.example.data.repository.commit

import com.rightpoint.mvi.example.cache.room.AppDatabase
import com.rightpoint.mvi.example.cache.room.model.CommitEntity
import com.rightpoint.mvi.example.data.NetworkBoundResource
import com.rightpoint.mvi.example.data.mapper.entities.CommitEntityMapper
import com.rightpoint.mvi.example.data.mapper.model.CommitModelMapper
import com.rightpoint.mvi.example.domain.executors.AppExecutors
import com.rightpoint.mvi.example.domain.model.CommitModel
import com.rightpoint.mvi.example.domain.repository.commit.CommitRepository
import com.rightpoint.mvi.example.remote.GithubApi
import com.rightpoint.mvi.example.remote.model.Commit
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class DefaultCommitRepository @Inject constructor(
    private val executors: AppExecutors,
    private val api: GithubApi,
    private val database: AppDatabase,
    private val entityMapper: CommitEntityMapper,
    private val modelMapper: CommitModelMapper
) : CommitRepository {
    override fun getListOfCommitsByRepo(owner: String, repo: String): Single<List<CommitModel>> {
        return api.getListOfCommitsForRepo(owner, repo)
            .map { it.map(entityMapper::map) }
            .map { it.map(modelMapper::map) }
    }
}