package com.rightpoint.mvi.example.data.injection

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.rightpoint.mvi.example.cache.room.DatabaseModule
import com.rightpoint.mvi.example.domain.executors.AppExecutors
import com.rightpoint.mvi.example.remote.NetworkModule
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module(includes = [DataBindings::class, DatabaseModule::class, NetworkModule::class])
object DataModule {
    @Provides
    @JvmStatic
    fun providesExecutors(): AppExecutors {
        return object : AppExecutors {
            override fun diskIo(): Scheduler {
                return Schedulers.from(Executors.newFixedThreadPool(3))
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
    @Singleton
    fun providesSharedPreferences(app: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app)
    }
}
