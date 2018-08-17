package com.rightpoint.github.mvi.cache.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.rightpoint.github.mvi.cache.room.model.RepoEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface RepoDao {
    @Query("SELECT * FROM RepoEntity")
    fun getAll(): Flowable<List<RepoEntity>>

    @Query("SELECT * FROM RepoEntity WHERE owner_login = :org")
    fun getReposByOrg(org: String): Flowable<List<RepoEntity>>

    @Query("SELECT * FROM RepoEntity WHERE owner_login = :org")
    fun checkReposByOrg(org: String): Single<List<RepoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: RepoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repos: List<RepoEntity>)
}