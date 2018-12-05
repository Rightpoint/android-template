package com.rightpoint.mvi.example.data.injection

import com.rightpoint.mvi.example.data.repository.commit.DefaultCommitRepository
import com.rightpoint.mvi.example.data.repository.repo.DefaultRepoRepository
import com.rightpoint.mvi.example.domain.repository.commit.CommitRepository
import com.rightpoint.mvi.example.domain.repository.repo.RepoRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataBindings {
    @Binds
    abstract fun bindRepoRepository(repository: DefaultRepoRepository): RepoRepository

    @Binds
    abstract fun bindCommitRepository(repository: DefaultCommitRepository): CommitRepository
}