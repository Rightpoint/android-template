package com.rightpoint.mvi.example.domain.model

data class CommitModel(
    val sha: String,
    val message: String,
    val commentCount: Int,
    val url: String,
    val htmlUrl: String,
    val commentsUrl: String,
    val author: OwnerModel?,
    val committer: OwnerModel?
)