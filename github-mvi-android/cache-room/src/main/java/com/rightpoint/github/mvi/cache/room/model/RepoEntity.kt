package com.rightpoint.github.mvi.cache.room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index

/**
 * Using name/owner_login as primary key instead of id since name/owner_login is always available
 * vs id is not.
 */
@Entity(
    indices = [
        Index("id"),
        Index("owner_login")
    ],
    primaryKeys = ["name", "owner_login"]
)
data class RepoEntity(
    @field:ColumnInfo(name = "id") val id: Long,
    @field:ColumnInfo(name = "name") val name: String,
    @field:ColumnInfo(name = "full_name") val full_name: String,
    @field:Embedded(prefix = "owner_") val owner: OwnerEntity,
    @field:ColumnInfo(name = "is_private") val is_private: Boolean,
    @field:ColumnInfo(name = "html_url") val html_url: String,
    @field:ColumnInfo(name = "description") val description: String?,
    @field:ColumnInfo(name = "fork") val fork: Boolean,
    @field:ColumnInfo(name = "url") val url: String,
    @field:ColumnInfo(name = "stargazers_count") val stargazers_count: Int,
    @field:ColumnInfo(name = "watchers_count") val watchers_count: Int,
    @field:ColumnInfo(name = "language") val language: String?,
    @field:ColumnInfo(name = "has_issues") val has_issues: Boolean,
    @field:ColumnInfo(name = "has_projects") val has_projects: Boolean,
    @field:ColumnInfo(name = "has_downloads") val has_downloads: Boolean,
    @field:ColumnInfo(name = "has_wiki") val has_wiki: Boolean,
    @field:ColumnInfo(name = "has_pages") val has_pages: Boolean,
    @field:ColumnInfo(name = "forks_count") val forks_count: Int,
    @field:ColumnInfo(name = "open_issues_count") val open_issues_count: Int
)