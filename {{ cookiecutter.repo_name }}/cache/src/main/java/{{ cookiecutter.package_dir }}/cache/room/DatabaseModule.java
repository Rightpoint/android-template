package {{ cookiecutter.package_name }}.cache.room;

import android.app.Application;
import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DatabaseModule {
    @Provides
    @Singleton
    static AppDatabase providesDatabase(Application app) {
        return Room.databaseBuilder(app, AppDatabase.class, "{{ cookiecutter.repo_name }}-db").build();
    }
}
