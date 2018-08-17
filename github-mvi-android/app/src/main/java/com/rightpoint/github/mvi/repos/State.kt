package com.rightpoint.github.mvi.repos

sealed class State {
    object Loading : State()
    data class Loaded(val data: List<RepoItem>) : State()
    data class Error(val error: Throwable) : State()
}