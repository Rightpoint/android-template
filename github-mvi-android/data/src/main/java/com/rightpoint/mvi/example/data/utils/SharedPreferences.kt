package com.rightpoint.mvi.example.data.utils

import android.content.SharedPreferences
import org.threeten.bp.Instant

fun SharedPreferences.Editor.putInstant(key: String, instant: Instant): SharedPreferences.Editor {
    return putLong(key, instant.toEpochMilli())
}

fun SharedPreferences.getInstant(key: String): Instant {
    val milli = getLong(key, -1L)
    return if (milli < 0) {
        Instant.now()
    } else {
        Instant.ofEpochMilli(milli)
    }
}