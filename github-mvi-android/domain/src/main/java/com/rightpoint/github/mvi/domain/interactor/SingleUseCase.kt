package com.rightpoint.github.mvi.domain.interactor

import io.reactivex.Single

abstract class SingleUseCase<in T, R> : UseCase<T, Single<R>>