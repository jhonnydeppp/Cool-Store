package com.jhonny.punkbeer.data.util.error

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorSource
}
