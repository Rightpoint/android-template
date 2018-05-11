package {{ cookiecutter.package_name }}.remote;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor.Level;

@Module
public abstract class NetworkSettings {
    @Provides
    static Level providesLoggingLevel() {
        return Level.NONE;
    }
}