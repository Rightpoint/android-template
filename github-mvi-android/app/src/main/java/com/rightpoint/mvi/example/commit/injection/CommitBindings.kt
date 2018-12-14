package com.rightpoint.mvi.example.commit.injection

import com.rightpoint.mvi.example.commit.CommitBottomSheetDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CommitBindings {
    @ContributesAndroidInjector(modules = [CommitModule::class])
    abstract fun commitDialog(): CommitBottomSheetDialog
}