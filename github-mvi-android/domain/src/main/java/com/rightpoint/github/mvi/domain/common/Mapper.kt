package com.rightpoint.github.mvi.domain.common

interface Mapper<T, R> {
    fun map(t: T): R
}