package com.jhonny.coolstore.extensions

import com.jhonny.coolstore.data.entities.Failure
import com.jhonny.coolstore.data.util.error.ErrorSource

fun Exception.toDomain() = when (this) {
    is ErrorSource.Network -> Failure.NoInternet
    is ErrorSource.ServiceError -> Failure.Source(errorCode, errorMessage, additionalMessage)
    else -> Failure.Generic
}
