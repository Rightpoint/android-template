package com.rightpoint.github.mvi.remote

import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor.Level

@Module
object NetworkSettings {
    @Provides
    @JvmStatic
    fun providesLoggingLevel(): Level {
        return Level.BODY
    }
}