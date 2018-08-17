package com.rightpoint.github.mvi.cache.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.rightpoint.github.mvi.cache.room.dao.RepoDao
import com.rightpoint.github.mvi.cache.room.model.OrganizationEntity
import com.rightpoint.github.mvi.cache.room.model.OwnerEntity
import com.rightpoint.github.mvi.cache.room.model.RepoEntity

@Database(entities = [
    RepoEntity::class,
    OwnerEntity::class,
    OrganizationEntity::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}