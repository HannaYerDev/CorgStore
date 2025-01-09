package com.aermakova.corgstore.ui.navigation

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder


fun performHomeNavigation(
    navController: NavHostController,
    route: String
) {
    if (navController.currentDestination?.parent?.route == route ||
        navController.currentDestination?.route == route
    ) {
        // Trying to open the destination twice, relevant for Home direction
        return
    }
    preformOneDirectionNavigation(navController, route)
}

fun preformOneDirectionNavigation(
    navController: NavHostController,
    route: String
) {
    navController.clearBackStack()
    navController.navigate(route) {
        navController.clearSelf(this)
    }
}

private fun NavHostController.clearBackStack() {
    while (previousBackStackEntry != null) {
        popBackStack()
    }
}

private fun NavHostController.clearSelf(options: NavOptionsBuilder) {
    currentDestination?.route?.let {
        options.popUpTo(it) { inclusive = true }
    }
}