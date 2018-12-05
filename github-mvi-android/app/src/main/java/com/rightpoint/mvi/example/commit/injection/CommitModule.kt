package com.rightpoint.mvi.example.commit.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.rightpoint.mvi.example.commit.CommitBottomSheetDialog
import com.rightpoint.mvi.example.commit.CommitViewModel
import com.rightpoint.mvi.example.domain.interactor.commit.GetListOfCommits
import dagger.Module
import dagger.Provides

@Module
object CommitModule {
    @Provides
    @JvmStatic
    fun providesViewModel(
        dialog: CommitBottomSheetDialog,
        getListOfCommits: GetListOfCommits
    ): CommitViewModel {
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CommitViewModel(getListOfCommits) as T
            }
        }
        return ViewModelProviders.of(dialog, factory)[CommitViewModel::class.java]
    }
}