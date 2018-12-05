package com.rightpoint.mvi.example.repo

sealed class Action {
    data class LoadListOfRepos(val organization: String) : Action()
}