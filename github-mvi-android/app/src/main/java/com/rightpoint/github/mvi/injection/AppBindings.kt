package com.rightpoint.github.mvi.injection

import com.rightpoint.github.mvi.repos.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindings {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}