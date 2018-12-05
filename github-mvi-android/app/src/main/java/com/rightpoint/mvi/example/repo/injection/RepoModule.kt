package com.rightpoint.mvi.example.repo.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rightpoint.mvi.example.domain.interactor.repo.GetListOfRepos
import com.rightpoint.mvi.example.repo.RepoListFragment
import com.rightpoint.mvi.example.repo.RepoListViewModel
import com.rightpoint.mvi.example.repo.model.RepoItemMapper
import dagger.Module
import dagger.Provides

@Module
object RepoModule {
    @Provides
    @JvmStatic
    fun providesMapper(fragment: RepoListFragment): RepoItemMapper {
        return RepoItemMapper(fragment.onCommitClick)
    }

    @Provides
    @JvmStatic
    fun providesViewModel(
        fragment: RepoListFragment,
        useCase: GetListOfRepos,
        mapper: RepoItemMapper
    ): RepoListViewModel {
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return RepoListViewModel(useCase, mapper) as T
            }
        }
        return ViewModelProviders.of(fragment, factory)[RepoListViewModel::class.java]
    }
}