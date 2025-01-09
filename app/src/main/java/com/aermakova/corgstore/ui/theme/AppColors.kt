package com.aermakova.corgstore.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

internal data class AppColors(
    val primaryBlack: Color = Color(0xFF303030),
    val secondary: Color = Color(0xFF606060),
    val light: Color = Color(0xFF909090),
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),
    val filterColor: Color = Color(0xFFF5F5F5),
    val counterColor: Color = Color(0XFFE0E0E0),
    val backgroundColor: Brush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFFFFF),
            Color(0xFFDCDCDC)
        )
    )
)
