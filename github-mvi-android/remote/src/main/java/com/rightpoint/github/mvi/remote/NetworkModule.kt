package com.rightpoint.github.mvi.remote

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module(includes = [NetworkSettings::class])
object NetworkModule {
    @Provides
    @JvmStatic
    fun providesBaseUrl(): HttpUrl? {
        return HttpUrl.parse("https://api.github.com/")
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providesRetrofit(url: HttpUrl?, level: HttpLoggingInterceptor.Level): Retrofit {
        val logging = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").v(message) }
        logging.level = level

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val moshi = Moshi.Builder()
            .add(AppJsonAdapterFactory.INSTANCE)
            .build()

        return Retrofit.Builder()
            .baseUrl(url!!)
            .client(client)
            .addCallAdapterFactory(
                RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
            )
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providesApi(retrofit: Retrofit): GithubApi {
        return retrofit.create(GithubApi::class.java)
    }
}