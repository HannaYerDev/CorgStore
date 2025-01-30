package com.aermakova.corgstore.ui.navigation

sealed class Screens(val route: String) {
    data object Boarding : Screens("boarding_route")
    data object Home : Screens("home_route")
    data object Favourites : Screens("favourites_route")
    data object Cart : Screens("cart_route")
    data object Profile : Screens("profile_route")
}


object ProductScreen {
    const val routeName = "product_route"
    const val argumentKey = "product_id"
    const val route = "$routeName?$argumentKey={$argumentKey}"
    const val routeFormat = "$routeName?$argumentKey=%s"
}



