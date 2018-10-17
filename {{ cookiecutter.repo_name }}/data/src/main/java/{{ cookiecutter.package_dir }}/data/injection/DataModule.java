package {{ cookiecutter.package_name }}.data.injection;

import {{ cookiecutter.package_name }}.cache.room.DatabaseModule;
import {{ cookiecutter.package_name }}.domain.executors.AppExecutors;
import {{ cookiecutter.package_name }}.remote.NetworkModule;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module(includes = {DatabaseModule.class, NetworkModule.class})
public abstract class DataModule {
    @Provides
    static AppExecutors providesExecutors() {
        return new AppExecutors() {
            @NotNull
            @Override
            public Scheduler diskIo() {
                return Schedulers.from(Executors.newFixedThreadPool(3));
            }

            @NotNull
            @Override
            public Scheduler networkIo() {
                return Schedulers.io();
            }

            @NotNull
            @Override
            public Scheduler mainThread() {
                return AndroidSchedulers.mainThread();
            }
        };
    }
}
