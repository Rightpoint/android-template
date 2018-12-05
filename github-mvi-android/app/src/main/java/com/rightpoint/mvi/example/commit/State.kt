package com.rightpoint.mvi.example.commit

sealed class State {
    object Loading : State()
    data class Loaded(val item: CommitItem) : State()
    object Empty : State()
    data class Error(val error: Throwable) : State()
}