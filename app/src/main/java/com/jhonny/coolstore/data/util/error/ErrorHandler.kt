package com.jhonny.coolstore.data.util.error

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorSource
}
