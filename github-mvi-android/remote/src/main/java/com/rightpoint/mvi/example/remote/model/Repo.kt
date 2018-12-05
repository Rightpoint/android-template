package com.rightpoint.mvi.example.remote.model

import com.squareup.moshi.Json

data class Repo(
    val id: Long,
    val name: String,
    val full_name: String,
    val owner: Owner,
    @Json(name = "private") val is_private: Boolean,
    val html_url: String,
    val description: String?,
    val fork: Boolean,
    val url: String,
    val stargazers_count: Int,
    val watchers_count: Int,
    val language: String?,
    val has_issues: Boolean,
    val has_projects: Boolean,
    val has_downloads: Boolean,
    val has_wiki: Boolean,
    val has_pages: Boolean,
    val forks_count: Int,
    val open_issues_count: Int
)