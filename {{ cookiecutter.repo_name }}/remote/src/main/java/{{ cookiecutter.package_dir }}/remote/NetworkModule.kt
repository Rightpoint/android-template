package {{ cookiecutter.package_name }}.remote

import com.squareup.moshi.Moshi
import dagger.Lazy
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

@Module(includes = [NetworkSettings::class])
object NetworkModule {
    @Provides
    @JvmStatic
    fun providesBaseUrl(): HttpUrl? {
        return HttpUrl.parse("TODO: Please provide an appropriate base URL!")
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providesOkHttpClient(level: HttpLoggingInterceptor.Level): OkHttpClient {
        val logging = HttpLoggingInterceptor { message -> Timber.tag("OkHttp").v(message) }
            .apply { this.level = level }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providesRetrofit(url: HttpUrl?, client: Lazy<OkHttpClient>): Retrofit {
        val moshi = Moshi.Builder().build()

        return Retrofit.Builder()
            .baseUrl(requireNotNull(url))
            .callFactory { client.get().newCall(it) }
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}