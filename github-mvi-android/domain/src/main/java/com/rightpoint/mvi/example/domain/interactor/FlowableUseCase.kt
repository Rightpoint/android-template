package com.rightpoint.mvi.example.domain.interactor

import io.reactivex.Flowable

abstract class FlowableUseCase<in T, R> : BaseUseCase<T, Flowable<R>>()