package com.rightpoint.github.mvi.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]

        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }

        checkNotNull(creator) {
            "Unknown ViewModel class: ${modelClass.name}"
        }

        try {
            @Suppress("UNCHECKED_CAST")
            return creator?.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}