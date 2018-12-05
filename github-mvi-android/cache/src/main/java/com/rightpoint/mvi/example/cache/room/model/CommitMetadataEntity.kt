package com.rightpoint.mvi.example.cache.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CommitMetadataEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @field:ColumnInfo(name = "message") val message: String,
    @field:ColumnInfo(name = "comment_count") val comment_count: Int
)