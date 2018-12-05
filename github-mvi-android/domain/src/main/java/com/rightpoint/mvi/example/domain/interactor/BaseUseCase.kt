package com.rightpoint.mvi.example.domain.interactor

abstract class BaseUseCase<in T, out R> {
    operator fun invoke(params: T): R {
        return execute(params)
    }

    protected abstract fun execute(params: T): R
}

operator fun <R> BaseUseCase<Unit, R>.invoke(): R = this(Unit)