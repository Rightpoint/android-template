package com.rightpoint.mvi.example.domain.model

data class RepoModel(
    val id: Long,
    val name: String,
    val fullName: String,
    val owner: OwnerModel,
    val isPrivate: Boolean,
    val htmlUrl: String,
    val description: String?,
    val fork: Boolean,
    val url: String,
    val stargazersCount: Int,
    val watchersCount: Int,
    val language: String?,
    val hasIssues: Boolean,
    val hasProjects: Boolean,
    val hasDownloads: Boolean,
    val hasWiki: Boolean,
    val hasPages: Boolean,
    val forksCount: Int,
    val openIssuesCount: Int
)