package com.aermakova.corgstore.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

@Composable
internal fun AppTheme(content: @Composable () -> Unit) = MaterialTheme {
    val colors = AppColors()
    val dimens = AppDimens()

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalDimens provides dimens,
        content = content,
    )
}

internal object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalColors.current

    val dimens: AppDimens
        @Composable
        get() = LocalDimens.current
}

private val LocalColors = compositionLocalOf<AppColors> {
    error("No colors provided")
}

private val LocalDimens = compositionLocalOf<AppDimens> {
    error("No dimens provided")
}
