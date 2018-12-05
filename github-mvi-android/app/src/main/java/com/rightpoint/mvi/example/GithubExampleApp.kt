package com.rightpoint.mvi.example

import android.os.StrictMode
import com.jakewharton.threetenabp.AndroidThreeTen
import com.rightpoint.mvi.example.injection.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber
import javax.inject.Inject

class GithubExampleApp : DaggerApplication() {
    @Inject lateinit var threadPolicy: StrictMode.ThreadPolicy
    @Inject lateinit var vmPolicy: StrictMode.VmPolicy
    @Inject lateinit var tree: Timber.Tree

    val component by lazy {
        DaggerAppComponent.builder().app(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        StrictMode.setThreadPolicy(threadPolicy)
        StrictMode.setVmPolicy(vmPolicy)
        Timber.plant(tree)
        AndroidThreeTen.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }
}