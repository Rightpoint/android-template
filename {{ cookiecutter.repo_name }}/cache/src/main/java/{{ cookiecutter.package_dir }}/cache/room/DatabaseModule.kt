package {{ cookiecutter.package_name }}.cache.room;

import android.app.Application
import androidx.room.Room

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {
    @Provides
    @Singleton
    @JvmStatic
    fun providesDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "{{ cookiecutter.repo_name }}-db").build()
    }
}