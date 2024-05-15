package com.jhonny.coolstore.data

import com.jhonny.coolstore.data.entities.ErrorCodeServer
import com.jhonny.coolstore.data.entities.Failure
import com.jhonny.coolstore.data.entities.ServerStatus
import com.jhonny.coolstore.util.orEmpty

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

/** Example how use error failure with code  **/
val Result<*>.isRequestUnauthorized
    get() = errorSourceOrNull()?.code == ServerStatus.UNAUTHORIZED.value
val Result<*>.isRequestUnavailable
    get() = errorSourceOrNull()?.code == ServerStatus.SERVER_UNAVAILABLE.value
val Result<*>.isTotalPackError
    get() = errorSourceOrNull()?.let {
        isRequestUnavailable &&
            it.additionalMessage == ErrorCodeServer.STATUS_SERVICE_UNAVAILABLE.name
    }.orEmpty()
val Result<*>.isSuccess
    get() = this is Result.Success
val Result<*>.isError
    get() = this is Result.Error

fun <T, R> Result<T>.map(transform: T.() -> R) =
    if (isSuccess) Result.Success(transform(getData())) else Result.Error(getError())

fun <T> Result<T>.getData() = (this as Result.Success).data
fun <T> Result<T>.getError() = (this as Result.Error).exception
fun <T> Result<T>.errorOrNull() = if (this.isError) this.getError() else null
fun <T> Result<T>.dataOrNull() = if (this.isSuccess) this.getData() else null
fun <T> Result<T>.errorSourceOrNull(): Failure.Source? {
    return when {
        isError && (getError() is Failure.Source) -> {
            getError() as Failure.Source
        }
        else -> null
    }
}
