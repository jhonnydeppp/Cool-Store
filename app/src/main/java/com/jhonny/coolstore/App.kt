package com.jhonny.coolstore

import android.app.Application
import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    object StoreSingletonList {
        val instance: MutableList<ProductPresentationItem?> by lazy {
            mutableListOf()
        }
    }
}