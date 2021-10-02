package com.phuongsala.domain.entity

sealed class Response<out T> {
    class Success<T>(val data: T) : Response<T>()
    class Failure(val error: Error) : Response<Nothing>()
}
