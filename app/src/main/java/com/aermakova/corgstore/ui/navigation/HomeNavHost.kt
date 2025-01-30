package com.aermakova.corgstore.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.home.HomeScreen
import com.aermakova.corgstore.ui.product.ProductScreen
import com.aermakova.corgstore.ui.theme.AppTheme


data class BottomNavigationItem(
    val label: String = "",
    @DrawableRes val filledInIcon: Int = R.drawable.home_solid,
    @DrawableRes val outlinedIcon: Int = R.drawable.home_solid,
    val route: String = ""
) {
    fun bottomNavigationItems(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Products",
                filledInIcon = R.drawable.home_solid,
                outlinedIcon = R.drawable.home_outlined,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Favourites",
                filledInIcon = R.drawable.favourite_solid,
                outlinedIcon = R.drawable.favourite_outlined,
                route = Screens.Favourites.route
            ),
            BottomNavigationItem(
                label = "Cart",
                filledInIcon = R.drawable.cart_solid,
                outlinedIcon = R.drawable.cart_outlined,
                route = Screens.Cart.route
            ),
            BottomNavigationItem(
                label = "Profile",
                filledInIcon = R.drawable.profile_solid,
                outlinedIcon = R.drawable.profile_outlined,
                route = Screens.Profile.route
            ),
        )
    }
}

@Composable
fun BottomNavigationBar() {
    var navigationSelectedItem by remember { mutableIntStateOf(0) }

    val navController = rememberNavController()

    Scaffold(
        containerColor = Color.White,
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .navigationBarsPadding()
                    .height(AppTheme.dimens.navBarHeight),
                containerColor = Color.White
            ) {
                BottomNavigationItem().bottomNavigationItems()
                    .forEachIndexed { index, navigationItem ->
                        NavigationItem(
                            selected = index == navigationSelectedItem,
                            navigationItem = navigationItem,
                            onClick = {
                                navigationSelectedItem = index
                                performHomeNavigation(
                                    navController = navController,
                                    route = navigationItem.route
                                )
                            }
                        )
                    }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier
                .padding(paddingValues = paddingValues)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(navController)
            }
            composable(Screens.Favourites.route) {
                HomeScreen(navController)
            }
            composable(Screens.Cart.route) {
                HomeScreen(navController)
            }
            composable(Screens.Profile.route) {
                HomeScreen(navController)
            }
            composable(
                route = ProductScreen.route,
                arguments = listOf(navArgument(ProductScreen.argumentKey) {
                    type = NavType.StringType
                })
            ) {
                ProductScreen(navController)
            }
        }
    }
}

@Composable
private fun RowScope.NavigationItem(
    selected: Boolean,
    navigationItem: BottomNavigationItem,
    onClick: () -> Unit
) {
    NavigationBarItem(
        selected = selected,
        icon = {
            Icon(
                painter = painterResource(
                    if (selected) navigationItem.filledInIcon else navigationItem.outlinedIcon
                ),
                contentDescription = navigationItem.label
            )
        },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.secondary,
            unselectedIconColor = MaterialTheme.colorScheme.onBackground,
            indicatorColor = Color.Transparent,
        ),
        onClick = onClick
    )
}

@Preview
@Composable
private fun BarPreview() {
    AppTheme {
        Row {
            NavigationItem(
                selected = true,
                navigationItem = BottomNavigationItem(
                    label = "Products",
                    filledInIcon = R.drawable.home_solid,
                    outlinedIcon = R.drawable.home_outlined,
                    route = Screens.Home.route
                ),
                onClick = {}
            )
        }
    }
}
