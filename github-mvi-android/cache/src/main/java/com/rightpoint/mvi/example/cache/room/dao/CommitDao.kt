package com.rightpoint.mvi.example.cache.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rightpoint.mvi.example.cache.room.model.CommitEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface CommitDao {
    @Query("SELECT * FROM CommitEntity")
    fun getAll(): Flowable<List<CommitEntity>>

    @Query("SELECT * FROM CommitEntity")
    fun check(): Single<List<CommitEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repo: CommitEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repos: List<CommitEntity>)
}