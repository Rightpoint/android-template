package com.rightpoint.github.mvi.cache.room

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {
    @Provides
    @Singleton
    @JvmStatic
    fun providesDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "github-mvi-android-db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
