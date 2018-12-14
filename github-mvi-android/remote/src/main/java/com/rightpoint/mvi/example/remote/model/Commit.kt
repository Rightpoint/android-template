package com.rightpoint.mvi.example.remote.model

data class Commit(
    val sha: String,
    val commit: Metadata,
    val url: String,
    val html_url: String,
    val comments_url: String,
    val author: Owner,
    val committer: Owner
) {
    data class Metadata(
        val message: String,
        val comment_count: Int
    )
}