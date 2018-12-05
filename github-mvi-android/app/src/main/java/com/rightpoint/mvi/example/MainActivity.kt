package com.rightpoint.mvi.example

import android.os.Bundle
import com.rightpoint.mvi.example.R
import com.rightpoint.mvi.example.repo.RepoListFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFrame, RepoListFragment())
            .commit()
    }
}