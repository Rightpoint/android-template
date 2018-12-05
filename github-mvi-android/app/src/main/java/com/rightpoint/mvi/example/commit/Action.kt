package com.rightpoint.mvi.example.commit

sealed class Action {
    data class LoadListOfCommits(val owner: String, val repo: String) : Action()
}