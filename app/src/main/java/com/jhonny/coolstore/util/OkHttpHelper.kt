package com.jhonny.coolstore.util

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpHelper {

    fun getOkHttpBuilder() =
        OkHttpClient.Builder().apply {
        connectTimeout(TIMEOUT, TimeUnit.MINUTES)
        readTimeout(TIMEOUT, TimeUnit.MINUTES)
        writeTimeout(TIMEOUT, TimeUnit.MINUTES)
    }
}
