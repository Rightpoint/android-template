package com.rightpoint.mvi.example.domain.model

data class OwnerModel(
    val login: String,
    val id: Long,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String,
    val type: String
)