package {{ cookiecutter.package_name }}.cache.realm;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public abstract class DatabaseModule {
    @Provides
    @Singleton
    static Realm providesDatabase(Application app) {
        Realm.init(app);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        return Realm.getInstance(configuration);
    }
}
