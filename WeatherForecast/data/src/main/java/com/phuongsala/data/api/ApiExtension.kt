package com.phuongsala.data.api

import android.accounts.NetworkErrorException
import com.phuongsala.domain.entity.Error
import com.phuongsala.domain.entity.Response
import retrofit2.HttpException

const val NETWORK_CONNECTION_ERROR = "Network connection error"
const val BAD_REQUEST_ERROR = "Bad request error"
const val NOT_FOUND_ERROR = "Not found error"
const val REQUEST_TIMEOUT_ERROR = "Request timeout error"

suspend fun <T> runWithCatchError(
    call: suspend () -> T,
    success: suspend (T) -> Unit,
    failure: suspend (Response.Failure) -> Unit
) {
    try {
        success.invoke(call.invoke())
    } catch (exception: Exception) {
        failure.invoke(exception.toResponseFailure())
    }
}

private fun Exception.toResponseFailure(): Response.Failure {
    val error = when (this) {
        is NetworkErrorException -> {
            Error(NETWORK_CONNECTION_ERROR)
        }
        is HttpException -> {
            when (code()) {
                400 -> Error(BAD_REQUEST_ERROR)
                404 -> Error(NOT_FOUND_ERROR)
                408 -> Error(REQUEST_TIMEOUT_ERROR)
                // we can define the other errors here
                else -> Error(message())
            }
        }
        else -> {
            Error(message)
        }
    }
    return Response.Failure(error)
}