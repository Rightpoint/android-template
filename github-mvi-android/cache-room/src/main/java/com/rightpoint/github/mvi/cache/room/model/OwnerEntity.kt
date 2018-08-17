package com.rightpoint.github.mvi.cache.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(primaryKeys = ["id"])
data class OwnerEntity(
    @field:ColumnInfo(name = "login") val login: String,
    @field:ColumnInfo(name = "id") val id: Long,
    @field:ColumnInfo(name = "avatar_url") val avatar_url: String,
    @field:ColumnInfo(name = "url") val url: String,
    @field:ColumnInfo(name = "html_url") val html_url: String,
    @field:ColumnInfo(name = "type") val type: String
)