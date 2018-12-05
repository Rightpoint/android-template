package com.rightpoint.mvi.example.domain.interactor

import io.reactivex.Completable

abstract class CompletableUseCase<in T> : BaseUseCase<T, Completable>()