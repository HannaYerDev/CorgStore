package com.aermakova.corgstore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aermakova.corgstore.domain.model.UserMode
import com.aermakova.corgstore.ui.boarding.BoardingScreen

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    userMode: UserMode
) {
    val startDestination = when (userMode) {
        UserMode.UNAUTHORISED -> Screens.Boarding.route
        UserMode.GUEST,
        UserMode.AUTHORIZED -> Screens.Home.route
    }
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        composable(Screens.Boarding.route) {
            BoardingScreen(navHostController)
        }
        composable(Screens.Home.route) {
            BottomNavigationBar()
        }
    }
}
