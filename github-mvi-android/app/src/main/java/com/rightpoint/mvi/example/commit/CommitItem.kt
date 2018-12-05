package com.rightpoint.mvi.example.commit

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CommitItem(
    val sha: String,
    val message: String,
    val commentCount: Int,
    val url: String,
    val htmlUrl: String,
    val commentsUrl: String,
    val authorLogin: String,
    val authorId: Long,
    val authorAvatarUrl: String,
    val authorUrl: String,
    val authorHtmlUrl: String
) : Parcelable