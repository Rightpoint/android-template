package {{ cookiecutter.package_name }}.remote;

import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import timber.log.Timber;

@Module(includes = {NetworkSettings.class})
public abstract class NetworkModule {
    @Provides
    static HttpUrl providesBaseUrl() {
        return HttpUrl.parse("TODO: Please provide an appropriate base URL!");
    }

    @Provides
    @Singleton
    static Retrofit providesRetrofit(HttpUrl url, HttpLoggingInterceptor.Level level) {
        HttpLoggingInterceptor logging =
                new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").v(message));
        logging.setLevel(level);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Moshi moshi = new Moshi.Builder()
                .add(AppJsonAdapterFactory.INSTANCE)
                .build();

        return new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory
                        .createWithScheduler(Schedulers.io()))
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();
    }
}