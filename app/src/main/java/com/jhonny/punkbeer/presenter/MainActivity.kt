package com.jhonny.punkbeer.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jhonny.punkbeer.presenter.entities.CocktailPresentation
import com.jhonny.punkbeer.presenter.navigation.AppNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    object FavoritesSingletonList {
        val instance: MutableList<CocktailPresentation> by lazy {
            mutableListOf()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AppNavigation() }

    }
}
