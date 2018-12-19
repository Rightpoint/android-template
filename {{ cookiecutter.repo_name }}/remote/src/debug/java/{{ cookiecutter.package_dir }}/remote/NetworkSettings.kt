package {{ cookiecutter.package_name }}.remote;

import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor.Level

@Module
internal object NetworkSettings {
    @Provides
    @JvmStatic
    fun providesLoggingLevel(): Level = Level.BODY
}