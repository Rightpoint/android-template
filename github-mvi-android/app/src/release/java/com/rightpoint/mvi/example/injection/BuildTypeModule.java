package com.rightpoint.mvi.example.injection;

import android.os.StrictMode;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
abstract class BuildTypeModule {
    @Provides
    static StrictMode.ThreadPolicy providesThreadPolicy() {
        return StrictMode.ThreadPolicy.LAX;
    }

    @Provides
    static StrictMode.VmPolicy providesVmPolicy() {
        return StrictMode.VmPolicy.LAX;
    }

    @Provides
    static Timber.Tree providesTree() {
        return new Timber.Tree() {
            @Override
            protected void log(int priority,
                               @Nullable String tag,
                               @NotNull String message,
                               @Nullable Throwable t) {
                // Do nothing
            }
        };
    }
}
