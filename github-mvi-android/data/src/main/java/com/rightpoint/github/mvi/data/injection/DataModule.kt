package com.rightpoint.github.mvi.data.injection

import com.rightpoint.github.mvi.cache.room.AppDatabase
import com.rightpoint.github.mvi.cache.room.DatabaseModule
import com.rightpoint.github.mvi.data.mapper.entities.RepoEntityMapper
import com.rightpoint.github.mvi.data.mapper.model.RepoModelMapper
import com.rightpoint.github.mvi.data.repository.repo.DefaultRepoRepository
import com.rightpoint.github.mvi.domain.executors.AppExecutors
import com.rightpoint.github.mvi.domain.repository.repo.RepoRepository
import com.rightpoint.github.mvi.remote.GithubApi
import com.rightpoint.github.mvi.remote.NetworkModule
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

@Module(includes = [DatabaseModule::class, NetworkModule::class])
object DataModule {
    @Provides
    @JvmStatic
    fun providesExecutors(): AppExecutors {
        return object : AppExecutors {
            override fun diskIo(): Scheduler {
                return Schedulers.from(Executors.newSingleThreadExecutor())
            }

            override fun networkIo(): Scheduler {
                return Schedulers.io()
            }

            override fun mainThread(): Scheduler {
                return AndroidSchedulers.mainThread()
            }
        }
    }

    @Provides
    @JvmStatic
    fun providesRepoRepository(
        executors: AppExecutors,
        api: GithubApi,
        database: AppDatabase,
        entityMapper: RepoEntityMapper,
        modelMapper: RepoModelMapper
    ): RepoRepository {
        return DefaultRepoRepository(
            executors = executors,
            api = api,
            database = database,
            entityMapper = entityMapper,
            modelMapper = modelMapper
        )
    }
}
