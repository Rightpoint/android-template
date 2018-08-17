package com.rightpoint.github.mvi.remote.model

data class Organization(
    val login: String,
    val id: Long,
    val avatar_url: String,
    val url: String,
    val html_url: String
)