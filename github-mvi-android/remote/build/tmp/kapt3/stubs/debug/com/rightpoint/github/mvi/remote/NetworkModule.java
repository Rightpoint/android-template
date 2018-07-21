package com.rightpoint.github.mvi.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/rightpoint/github/mvi/remote/NetworkModule;", "", "()V", "providesApi", "Lcom/rightpoint/github/mvi/remote/GithubApi;", "retrofit", "Lretrofit2/Retrofit;", "providesBaseUrl", "Lokhttp3/HttpUrl;", "providesRetrofit", "url", "level", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "remote_debug"})
@dagger.Module(includes = {com.rightpoint.github.mvi.remote.NetworkSettings.class})
public final class NetworkModule {
    public static final com.rightpoint.github.mvi.remote.NetworkModule INSTANCE = null;
    
    @org.jetbrains.annotations.Nullable()
    @dagger.Provides()
    public static final okhttp3.HttpUrl providesBaseUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public static final retrofit2.Retrofit providesRetrofit(@org.jetbrains.annotations.Nullable()
    okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull()
    okhttp3.logging.HttpLoggingInterceptor.Level level) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public static final com.rightpoint.github.mvi.remote.GithubApi providesApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    private NetworkModule() {
        super();
    }
}