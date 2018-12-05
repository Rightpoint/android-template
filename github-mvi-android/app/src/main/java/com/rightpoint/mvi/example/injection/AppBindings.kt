package com.rightpoint.mvi.example.injection

import com.rightpoint.mvi.example.MainActivity
import com.rightpoint.mvi.example.repo.injection.RepoBindings
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppBindings {
    @ContributesAndroidInjector(modules = [RepoBindings::class])
    abstract fun mainActivity(): MainActivity
}