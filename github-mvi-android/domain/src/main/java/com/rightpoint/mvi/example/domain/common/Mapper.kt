package com.rightpoint.mvi.example.domain.common

interface Mapper<T, R> {
    fun map(t: T): R
}