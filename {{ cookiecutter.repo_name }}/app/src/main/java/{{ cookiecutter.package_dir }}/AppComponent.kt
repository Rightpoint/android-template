package {{ cookiecutter.package_name }}

import android.app.Application
import {{ cookiecutter.package_name }}.data.injection.DataModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    BuildTypeModule::class,
    DataModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}