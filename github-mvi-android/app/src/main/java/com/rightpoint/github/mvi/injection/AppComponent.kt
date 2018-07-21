package com.rightpoint.github.mvi.injection

import android.app.Application
import com.rightpoint.github.mvi.GithubExampleApp
import com.rightpoint.github.mvi.data.injection.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppBindings::class,
    BuildTypeModule::class,
    DataModule::class,
    ViewModelBindings::class
])
interface AppComponent : AndroidInjector<GithubExampleApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}