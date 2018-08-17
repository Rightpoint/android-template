package com.rightpoint.github.mvi.domain.interactor

import io.reactivex.Completable

abstract class CompletableUseCase<in T> : UseCase<T, Completable>