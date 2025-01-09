package com.aermakova.corgstore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aermakova.corgstore.ui.boarding.BoardingScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Boarding.route,
    ) {
        composable(Screens.Boarding.route) {
            BoardingScreen(navHostController)
        }
        composable(Screens.Home.route) {
            BottomNavigationBar()
        }
    }
}
