package com.rightpoint.mvi.example.repo

import com.rightpoint.mvi.example.repo.model.RepoItem

sealed class State {
    object Loading : State()
    data class Loaded(val data: List<RepoItem>) : State()
    object Empty : State()
    data class Error(val error: Throwable) : State()
}