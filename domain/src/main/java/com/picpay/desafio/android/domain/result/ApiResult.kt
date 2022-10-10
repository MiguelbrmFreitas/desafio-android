package com.picpay.desafio.android.domain.result

import java.lang.Exception

sealed class ApiResult<out R> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Failure(val message: String): ApiResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success data: $data]"
            is Failure -> "Error exception: $message]"
        }
    }
}