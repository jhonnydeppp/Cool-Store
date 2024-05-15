package com.jhonny.coolstore.presenter.navigation

sealed class AppScreens(val route: String, val  name: String) {
    object TabbedScreen: AppScreens("tabbed_screen","Tab Screen")
    object MainScreen: AppScreens("main_screen", "Productos")
    object DetailScreen: AppScreens("detail_screen", "Detalle")
    object CarScreen: AppScreens("car_screen", "Carrito")
}
