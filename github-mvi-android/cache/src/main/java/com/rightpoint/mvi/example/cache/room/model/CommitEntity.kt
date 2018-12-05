package com.rightpoint.mvi.example.cache.room.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

@Entity(primaryKeys = ["sha"])
data class CommitEntity(
    @field:ColumnInfo(name = "sha") val sha: String,
    @field:Embedded(prefix = "commit_") val commit: CommitMetadataEntity,
    @field:ColumnInfo(name = "url") val url: String,
    @field:ColumnInfo(name = "html_url") val html_url: String,
    @field:ColumnInfo(name = "comments_url") val comments_url: String,
    @field:Embedded(prefix = "author_") val author: OwnerEntity?,
    @field:Embedded(prefix = "committer_") val committer: OwnerEntity?
)