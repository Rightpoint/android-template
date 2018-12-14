package com.rightpoint.mvi.example.cache.room;

import android.app.Application;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class DatabaseModule {
    @Provides
    @Singleton
    static AppDatabase providesDatabase(Application app) {
        return Room.databaseBuilder(app, AppDatabase.class, "github-mvi-android.db").build();
    }
}
