package com.phuongsala.presentation.common

import com.phuongsala.domain.entity.Error

sealed class State<out T> {
    object Loading : State<Nothing>()
    class Success<T>(val data: T) : State<T>()
    class Failure(val error: Error) : State<Nothing>()
}