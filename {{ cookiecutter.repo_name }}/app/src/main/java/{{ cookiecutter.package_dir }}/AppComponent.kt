package {{ cookiecutter.package_name }}

import android.app.Application
import {{ cookiecutter.package_name }}.data.injection.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    BuildTypeModule::class,
    DataModule::class
])
interface AppComponent : AndroidInjector<{{ cookiecutter.app_name | replace(' ', '') }}App> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}