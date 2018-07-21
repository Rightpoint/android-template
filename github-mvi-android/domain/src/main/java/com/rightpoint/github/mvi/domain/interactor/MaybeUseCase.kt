package com.rightpoint.github.mvi.domain.interactor

import io.reactivex.Maybe

abstract class MaybeUseCase<in T, R> : UseCase<T, Maybe<R>>