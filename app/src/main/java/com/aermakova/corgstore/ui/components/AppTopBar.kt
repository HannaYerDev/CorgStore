package com.aermakova.corgstore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.navigation.Screens
import com.aermakova.corgstore.ui.theme.AppStrings
import com.aermakova.corgstore.ui.theme.AppTheme
import com.aermakova.corgstore.ui.theme.gelasioRegular18
import com.aermakova.corgstore.ui.theme.gelasioSemiBold18

@Composable
fun AppTopBar(
    screen: Screens
) {
    Row(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(AppTheme.dimens.spacing20),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                R.drawable.ic_search
            ),
            contentDescription = "search"
        )

        when (screen) {
            Screens.Home -> HomeScreenTitle()
            Screens.Boarding -> HomeScreenTitle()
            Screens.Cart -> HomeScreenTitle()
            Screens.Favourites -> HomeScreenTitle()
            Screens.Profile -> HomeScreenTitle()
        }

        Image(
            painter = painterResource(
                R.drawable.ic_notification
            ),
            contentDescription = "notification"
        )
    }
}

@Composable
private fun HomeScreenTitle() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = AppStrings.homeTitle1,
            style = gelasioRegular18.copy(
                color = AppTheme.colors.light
            ),
        )
        Text(
            text = AppStrings.homeTitle2.uppercase(),
            style = gelasioSemiBold18
        )
    }
}

@Preview
@Composable
private fun AppTopBarPreview() {
    AppTheme {
        AppTopBar(Screens.Home)
    }
}