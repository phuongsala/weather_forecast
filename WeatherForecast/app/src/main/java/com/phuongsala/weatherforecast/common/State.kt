package com.phuongsala.weatherforecast.common

import com.phuongsala.domain.entity.Error

sealed class State<out T> {
    class Loading(val loading: Boolean) : State<Nothing>()
    class Success<T>(val data: T) : State<T>()
    class Failure(val error: Error) : State<Nothing>()
}