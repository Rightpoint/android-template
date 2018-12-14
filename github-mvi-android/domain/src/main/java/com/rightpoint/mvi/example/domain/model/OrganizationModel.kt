package com.rightpoint.mvi.example.domain.model

data class OrganizationModel(
    val login: String,
    val id: Long,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String
)