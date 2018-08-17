package com.rightpoint.github.mvi

import android.os.StrictMode
import com.rightpoint.github.mvi.injection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class GithubExampleApp : DaggerApplication() {
    @Inject lateinit var threadPolicy: StrictMode.ThreadPolicy
    @Inject lateinit var vmPolicy: StrictMode.VmPolicy
    @Inject lateinit var tree: Timber.Tree

    override fun onCreate() {
        super.onCreate()

        StrictMode.setThreadPolicy(threadPolicy)
        StrictMode.setVmPolicy(vmPolicy)
        Timber.plant(tree)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().app(this).build()
    }
}