package com.rightpoint.github.mvi.domain.interactor

interface UseCase<in T, out R> {
    fun execute(params: T? = null): R
}