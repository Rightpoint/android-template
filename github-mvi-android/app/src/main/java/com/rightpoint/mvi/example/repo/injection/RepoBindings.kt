package com.rightpoint.mvi.example.repo.injection

import com.rightpoint.mvi.example.commit.injection.CommitBindings
import com.rightpoint.mvi.example.repo.RepoListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RepoBindings {
    @ContributesAndroidInjector(modules = [RepoModule::class, CommitBindings::class])
    abstract fun repoListFragment(): RepoListFragment
}