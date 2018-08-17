package com.rightpoint.github.mvi.domain.interactor

import io.reactivex.Flowable

abstract class FlowableUseCase<in T, R> : UseCase<T, Flowable<R>>