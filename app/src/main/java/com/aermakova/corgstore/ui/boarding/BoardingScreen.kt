package com.aermakova.corgstore.ui.boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.navigation.Screens
import com.aermakova.corgstore.ui.navigation.preformOneDirectionNavigation
import com.aermakova.corgstore.ui.theme.AppStrings
import com.aermakova.corgstore.ui.theme.AppTheme
import com.aermakova.corgstore.ui.theme.gelasioBold30
import com.aermakova.corgstore.ui.theme.gelasioRegular18
import com.aermakova.corgstore.ui.theme.gelasioSemiBold18
import com.aermakova.corgstore.ui.theme.gelasioSemiBold24
import com.aermakova.corgstore.ui.theme.nunitoSansRegular18

@Composable
fun BoardingScreen(
    navController: NavHostController
) {
    val viewModel: BoardingViewModel = hiltViewModel()
    AppTheme {
        BoardingScreenContent(
            navController = navController,
            onAction = viewModel::onAction
        )
    }
}

@Composable
private fun BoardingScreenContent(
    navController: NavHostController,
    onAction: (BoardingAction) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeContent,
        content = { paddingValues ->
            BoardingContent(
                modifier = Modifier.padding(paddingValues),
                onLogIn = {
                    preformOneDirectionNavigation(
                        navController = navController,
                        route = Screens.LogIn.route
                    )
                },
                onStartAsGuest = {
                    onAction(BoardingAction.StartAsGuest)
                    preformOneDirectionNavigation(
                        navController = navController,
                        route = Screens.Home.route
                    )
                }
            )
        }
    )
}

@Composable
private fun BoardingContent(
    modifier: Modifier = Modifier,
    onLogIn: () -> Unit,
    onStartAsGuest: () -> Unit
) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.boarding_bg),
            contentDescription = "boarding screen bg",
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = AppTheme.dimens.spacing30),
        ) {
            Spacer(Modifier.weight(2.5f))
            Column(
                modifier = Modifier.weight(3f)
            ) {
                Text(
                    text = AppStrings.boardingTitle1.uppercase(),
                    style = gelasioSemiBold24.copy(
                        color = AppTheme.colors.secondary
                    ),
                )
                Spacer(Modifier.height(AppTheme.dimens.spacing8))
                Text(
                    text = AppStrings.boardingTitle2.uppercase(),
                    style = gelasioBold30.copy(
                        color = AppTheme.colors.primaryBlack
                    ),
                )
                Text(
                    modifier = Modifier.padding(
                        top = AppTheme.dimens.spacing36,
                        start = AppTheme.dimens.spacing30
                    ),
                    textAlign = TextAlign.Justify,
                    text = AppStrings.boardingDescription,
                    style = nunitoSansRegular18.copy(
                        color = Color(0xFF808080),
                    )
                )
            }

            Column(
                modifier = Modifier
                    .weight(2f)
                    .align(alignment = Alignment.CenterHorizontally),
            ) {
                Text(
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .clickable {
                            onLogIn()
                        }
                        .background(
                            color = AppTheme.colors.black,
                            shape = RoundedCornerShape(AppTheme.dimens.spacing4)
                        )
                        .padding(
                            vertical = AppTheme.dimens.spacing12,
                            horizontal = AppTheme.dimens.spacing24
                        ),
                    text = AppStrings.getStarted,
                    style = gelasioSemiBold18.copy(
                        color = AppTheme.colors.white
                    ),
                )

                Text(
                    modifier = Modifier
                        .clickable {
                            onStartAsGuest()
                        }
                        .padding(
                            vertical = AppTheme.dimens.spacing12,
                            horizontal = AppTheme.dimens.spacing24
                        ),
                    text = AppStrings.startAsGuest,
                    style = gelasioRegular18
                )
            }
        }
    }
}

@Preview
@Composable
private fun BoardingContentPreview() {
    AppTheme {
        BoardingContent(
            onLogIn = {},
            onStartAsGuest = {}
        )
    }
}
