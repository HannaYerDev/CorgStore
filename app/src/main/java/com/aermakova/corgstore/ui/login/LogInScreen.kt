package com.aermakova.corgstore.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.aermakova.corgstore.ui.components.EmailInputField
import com.aermakova.corgstore.ui.components.GoogleButton
import com.aermakova.corgstore.ui.components.Header
import com.aermakova.corgstore.ui.components.PasswordInputField
import com.aermakova.corgstore.ui.theme.AppStrings
import com.aermakova.corgstore.ui.theme.AppTheme
import com.aermakova.corgstore.ui.theme.gelasioBold30
import com.aermakova.corgstore.ui.theme.gelasioSemiBold16
import com.aermakova.corgstore.ui.theme.gelasioSemiBold18
import com.aermakova.corgstore.ui.theme.gelasioSemiBold30

@Composable
fun LogInScreen(
) {
    AppTheme {
        LogInScreenContent(

        )
    }
}

@Composable
private fun LogInScreenContent() {
    Surface(
        modifier = Modifier.background(color = AppTheme.colors.backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = AppTheme.dimens.spacing52)
        ) {

            Column(
                modifier = Modifier.padding(horizontal = AppTheme.dimens.spacing30)
            ) {
                Header()
                Text(
                    modifier = Modifier.padding(top = AppTheme.dimens.spacing30),
                    text = AppStrings.logInTitle1,
                    style = gelasioSemiBold30.copy(
                        color = AppTheme.colors.light
                    )
                )
                Spacer(Modifier.height(AppTheme.dimens.spacing8))
                Text(
                    text = AppStrings.logInTitle2.uppercase(),
                    style = gelasioBold30.copy(
                        color = AppTheme.colors.primaryBlack
                    ),
                )
                Spacer(Modifier.height(AppTheme.dimens.spacing24))


            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = AppTheme.dimens.spacing30)
                    .background(AppTheme.colors.white),
            ) {
                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing30))

                EmailInputField(modifier = Modifier.padding(start = AppTheme.dimens.spacing30)) { }

                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing30))


                PasswordInputField(modifier = Modifier.padding(start = AppTheme.dimens.spacing30)) { }

                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing30))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = AppStrings.forgotPassword,
                    style = gelasioSemiBold16.copy(
                        color = AppTheme.colors.light
                    ),
                )
                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing16))

                LogInButton(modifier = Modifier.padding(horizontal = AppTheme.dimens.spacing30)) {}

                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing16))

                GoogleButton(
                    modifier = Modifier.padding(horizontal = AppTheme.dimens.spacing30),
                    backgroundColor = AppTheme.colors.white
                ) {}

                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing16))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = AppStrings.or,
                    style = gelasioSemiBold16.copy(
                        color = AppTheme.colors.light
                    ),
                )
                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing16))

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        },
                    textAlign = TextAlign.Center,
                    text = AppStrings.signUp,
                    style = gelasioSemiBold18.copy(
                        color = AppTheme.colors.primaryBlack
                    ),
                )
                Spacer(modifier = Modifier.height(AppTheme.dimens.spacing30))


            }
        }
    }
}

@Composable
private fun LogInButton(modifier: Modifier, onLogIn: () -> Unit) {
    Text(
        modifier = modifier
            .fillMaxWidth()
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
        textAlign = TextAlign.Center,
        text = AppStrings.getStarted,
        style = gelasioSemiBold18.copy(
            color = AppTheme.colors.white
        ),
    )
}

@Preview
@Composable
private fun LogInScreenContentPreview() {
    AppTheme {
        LogInScreenContent()
    }
}