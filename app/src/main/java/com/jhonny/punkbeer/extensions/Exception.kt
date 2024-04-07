package com.jhonny.punkbeer.extensions

import com.jhonny.punkbeer.data.entities.Failure
import com.jhonny.punkbeer.data.util.error.ErrorSource

fun Exception.toDomain() = when (this) {
    is ErrorSource.Network -> Failure.NoInternet
    is ErrorSource.ServiceError -> Failure.Source(errorCode, errorMessage, additionalMessage)
    else -> Failure.Generic
}
