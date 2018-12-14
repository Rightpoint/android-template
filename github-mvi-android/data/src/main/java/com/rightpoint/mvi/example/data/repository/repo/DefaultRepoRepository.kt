package com.rightpoint.mvi.example.data.repository.repo

import android.content.SharedPreferences
import com.rightpoint.mvi.example.cache.room.AppDatabase
import com.rightpoint.mvi.example.cache.room.model.RepoEntity
import com.rightpoint.mvi.example.data.NetworkBoundResource
import com.rightpoint.mvi.example.data.mapper.entities.RepoEntityMapper
import com.rightpoint.mvi.example.data.mapper.model.RepoModelMapper
import com.rightpoint.mvi.example.data.utils.getInstant
import com.rightpoint.mvi.example.data.utils.putInstant
import com.rightpoint.mvi.example.domain.executors.AppExecutors
import com.rightpoint.mvi.example.domain.model.RepoModel
import com.rightpoint.mvi.example.domain.repository.repo.RepoRepository
import com.rightpoint.mvi.example.remote.GithubApi
import com.rightpoint.mvi.example.remote.model.Repo
import io.reactivex.Flowable
import io.reactivex.Single
import org.threeten.bp.Duration
import org.threeten.bp.Instant
import javax.inject.Inject

class DefaultRepoRepository @Inject constructor(
    private val executors: AppExecutors,
    private val api: GithubApi,
    private val database: AppDatabase,
    private val entityMapper: RepoEntityMapper,
    private val modelMapper: RepoModelMapper,
    private val preferences: SharedPreferences
) : RepoRepository {
    override fun getListOfReposByOrg(org: String): Flowable<List<RepoModel>> {
        val dao = database.repoDao()
        return object : NetworkBoundResource<List<Repo>, List<RepoEntity>>(executors) {
            override fun checkDb(): Single<List<RepoEntity>> {
                return dao.checkReposByOrg(org)
            }

            override fun openDbConnection(): Flowable<List<RepoEntity>> {
                return dao.getAll()
            }

            override fun shouldFetch(data: List<RepoEntity>): Boolean {
                val cacheInstant = preferences.getInstant(org)
                return data.isEmpty() ||
                    Duration.between(cacheInstant, Instant.now()).toMinutes() > 10
            }

            override fun saveToDb(data: List<RepoEntity>) {
                dao.insertAll(data)
                preferences.edit()
                    .putInstant(org, Instant.now())
                    .apply()
            }

            override fun fetchFromNetwork(): Single<List<Repo>> {
                return api.getListOfReposByOrg(org)
            }

            override fun mapTo(data: List<Repo>): List<RepoEntity> {
                return data.map(entityMapper::map)
            }
        }.asFlowable().map { it.map(modelMapper::map) }
    }

    override fun getRepo(owner: String, repo: String): Flowable<RepoModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}