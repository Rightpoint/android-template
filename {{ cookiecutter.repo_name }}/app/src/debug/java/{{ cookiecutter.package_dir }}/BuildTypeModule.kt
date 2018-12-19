package {{ cookiecutter.package_name }};

import android.os.StrictMode

import dagger.Module
import dagger.Provides
import timber.log.Timber

@Module
internal object BuildTypeModule {
    @Provides
    @JvmStatic
    fun providesThreadPolicy(): StrictMode.ThreadPolicy {
        return StrictMode.ThreadPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build()
    }

    @Provides
    @JvmStatic
    fun providesVmPolicy(): StrictMode.VmPolicy {
        return StrictMode.VmPolicy.Builder()
            .detectAll()
            .penaltyLog()
            .build()
    }

    @Provides
    @JvmStatic
    fun providesTree(): Timber.Tree {
        return Timber.DebugTree()
    }
}