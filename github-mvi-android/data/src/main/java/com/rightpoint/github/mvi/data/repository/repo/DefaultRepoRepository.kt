package com.rightpoint.github.mvi.data.repository.repo

import com.rightpoint.github.mvi.cache.room.AppDatabase
import com.rightpoint.github.mvi.cache.room.model.RepoEntity
import com.rightpoint.github.mvi.data.NetworkBoundResource
import com.rightpoint.github.mvi.data.mapper.entities.RepoEntityMapper
import com.rightpoint.github.mvi.data.mapper.model.RepoModelMapper
import com.rightpoint.github.mvi.domain.executors.AppExecutors
import com.rightpoint.github.mvi.domain.model.RepoModel
import com.rightpoint.github.mvi.domain.repository.repo.RepoRepository
import com.rightpoint.github.mvi.remote.GithubApi
import com.rightpoint.github.mvi.remote.model.Repo
import io.reactivex.Flowable
import io.reactivex.Single

class DefaultRepoRepository(
    private val executors: AppExecutors,
    private val api: GithubApi,
    private val database: AppDatabase,
    private val entityMapper: RepoEntityMapper,
    private val modelMapper: RepoModelMapper
) : RepoRepository {
    override fun getListOfReposByOrg(org: String): Flowable<List<RepoModel>> {
        val dao = database.repoDao()
        return object : NetworkBoundResource<List<Repo>, List<RepoEntity>>(executors) {
            override fun checkDb(): Single<List<RepoEntity>> {
                return dao.checkReposByOrg(org)
            }

            override fun openDbConnection(): Flowable<List<RepoEntity>> {
                return dao.getReposByOrg(org)
            }

            override fun shouldFetch(data: List<RepoEntity>): Boolean {
                return true
            }

            override fun saveToDb(data: List<RepoEntity>) {
                dao.insertAll(data)
            }

            override fun fetchFromNetwork(): Single<List<Repo>> {
                return api.getListOfReposByOrg(org)
            }

            override fun mapTo(data: List<Repo>): List<RepoEntity> {
                val entities = mutableListOf<RepoEntity>()
                for (repo in data) {
                    entities.add(entityMapper.map(repo))
                }
                return entities
            }
        }.asFlowable().map(this::mapToModel)
    }

    private fun mapToModel(entities: List<RepoEntity>): List<RepoModel> {
        val models = mutableListOf<RepoModel>()
        for (entity in entities) {
            models.add(modelMapper.map(entity))
        }
        return models
    }

    override fun getRepo(owner: String, repo: String): Flowable<RepoModel> {
        TODO("not implemented")
    }
}