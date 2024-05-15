package com.jhonny.coolstore.presenter.navigation

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jhonny.coolstore.presenter.detail.DetailScreen
import com.jhonny.coolstore.presenter.entities.ProductPresentationItem
import com.jhonny.coolstore.presenter.resume.ResumeScreen
import com.jhonny.coolstore.presenter.main.MainScreen
import com.jhonny.coolstore.util.parcelable

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.MainScreen.route
    ) {
        composable(AppScreens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(AppScreens.CarScreen.route) {
            ResumeScreen(navController)
        }
        composable(route = AppScreens.DetailScreen.route + "/{beer}", arguments =
        listOf(navArgument(name = "beer") {
            type = NavType.StringType

        })
        ) {
            val beer: Parcelable? =  it.arguments?.parcelable("beer")
            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<ProductPresentationItem?>("beer")
            DetailScreen(navController, result?: ProductPresentationItem())

        }
    }
}