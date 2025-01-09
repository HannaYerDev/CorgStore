package com.aermakova.corgstore.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.navigation.MainNavHost
import com.aermakova.corgstore.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        setTheme(R.style.Theme_CorgStore)
        super.onCreate(savedInstanceState)
        setUpTranslucentSystemBars()

        setContent {
            MainContent()
        }
    }

    private fun setUpTranslucentSystemBars() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightNavigationBars = true
            isAppearanceLightStatusBars = true
        }
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.navigationBarColor = ContextCompat.getColor(this, android.R.color.transparent)
    }
}

@Composable
internal fun MainContent() {
    val navController = rememberNavController()
    AppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = AppTheme.colors.white
        ) {
            MainNavHost(
                navHostController = navController
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MainContentPreview() {
    MainContent()
}
