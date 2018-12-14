package com.rightpoint.mvi.example.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rightpoint.mvi.example.cache.room.dao.CommitDao
import com.rightpoint.mvi.example.cache.room.dao.RepoDao
import com.rightpoint.mvi.example.cache.room.model.CommitEntity
import com.rightpoint.mvi.example.cache.room.model.CommitMetadataEntity
import com.rightpoint.mvi.example.cache.room.model.OrganizationEntity
import com.rightpoint.mvi.example.cache.room.model.OwnerEntity
import com.rightpoint.mvi.example.cache.room.model.RepoEntity

@Database(entities = [
    RepoEntity::class,
    OwnerEntity::class,
    OrganizationEntity::class,
    CommitEntity::class,
    CommitMetadataEntity::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
    abstract fun commitDao(): CommitDao
}