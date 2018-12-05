package com.rightpoint.mvi.example.injection;

import android.os.StrictMode;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
abstract class BuildTypeModule {
    @Provides
    static StrictMode.ThreadPolicy providesThreadPolicy() {
        return new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
    }

    @Provides
    static StrictMode.VmPolicy providesVmPolicy() {
        return new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build();
    }

    @Provides
    static Timber.Tree providesTree() {
        return new Timber.DebugTree();
    }
}
