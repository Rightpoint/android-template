package {{ cookiecutter.package_name }}

import android.os.StrictMode

import dagger.Module
import dagger.Provides
import timber.log.Timber

@Module
internal object BuildTypeModule {
    @Provides
    @JvmStatic
    fun providesThreadPolicy(): StrictMode.ThreadPolicy {
        return StrictMode.ThreadPolicy.LAX
    }

    @Provides
    @JvmStatic
    fun providesVmPolicy(): StrictMode.VmPolicy {
        return StrictMode.VmPolicy.LAX
    }

    @Provides
    @JvmStatic
    fun providesTree(): Timber.Tree {
        return object : Timber.Tree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                // Do nothing
            }
        }
    }
}
