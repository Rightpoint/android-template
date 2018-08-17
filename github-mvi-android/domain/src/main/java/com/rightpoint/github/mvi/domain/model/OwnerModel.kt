package com.rightpoint.github.mvi.domain.model

data class OwnerModel(
    val login: String,
    val id: Long,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String,
    val type: String
)