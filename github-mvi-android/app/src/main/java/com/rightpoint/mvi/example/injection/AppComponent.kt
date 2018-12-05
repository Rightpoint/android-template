package com.rightpoint.mvi.example.injection

import android.app.Application
import com.rightpoint.mvi.example.GithubExampleApp
import com.rightpoint.mvi.example.data.injection.DataModule
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
    DataModule::class
])
interface AppComponent : AndroidInjector<GithubExampleApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun app(app: Application): Builder
        fun build(): AppComponent
    }
}