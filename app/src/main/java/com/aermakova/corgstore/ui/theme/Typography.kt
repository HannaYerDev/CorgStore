package com.aermakova.corgstore.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aermakova.corgstore.R

private val Gelasio = FontFamily(
    Font(R.font.gelasio_bold, FontWeight.Bold),
    Font(R.font.gelasio_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.gelasio_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.gelasio_medium, FontWeight.Medium),
    Font(R.font.gelasio_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.gelasio_regular),
    Font(R.font.gelasio_semi_bold, FontWeight.SemiBold),
    Font(R.font.gelasio_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
)

private val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_regular),
    Font(R.font.nunito_sans_bold, FontWeight.Bold),
)

val gelasioRegular18 = TextStyle(
    fontFamily = Gelasio,
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight.Normal,
)

val gelasioRegular24 = TextStyle(
    fontFamily = Gelasio,
    fontSize = 24.sp,
    lineHeight = 24.sp,
    fontWeight = FontWeight.Normal,
)
val gelasioSemiBold16 = TextStyle(
    fontFamily = Gelasio,
    fontSize = 16.sp,
    lineHeight = 16.sp,
    fontWeight = FontWeight.SemiBold,
)

val gelasioSemiBold18 = TextStyle(
    fontFamily = Gelasio,
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight.SemiBold,
)

val gelasioSemiBold24 = TextStyle(
    fontFamily = Gelasio,
    fontSize = 24.sp,
    lineHeight = 24.sp,
    fontWeight = FontWeight.SemiBold,
)

val gelasioSemiBold30 = TextStyle(
    fontFamily = Gelasio,
    fontSize = 30.sp,
    lineHeight = 30.sp,
    fontWeight = FontWeight.SemiBold,
)

val gelasioBold30 = TextStyle(
    fontFamily = Gelasio,
    fontSize = 30.sp,
    lineHeight = 30.sp,
    fontWeight = FontWeight.Bold,
)

val nunitoSansLight14 = TextStyle(
    fontFamily = NunitoSans,
    fontSize = 14.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight.Light,
)

val nunitoSansRegular18 = TextStyle(
    fontFamily = NunitoSans,
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight.Normal,
)

val nunitoSansRegular14 = TextStyle(
    fontFamily = NunitoSans,
    fontSize = 14.sp,
    lineHeight = 14.sp,
    fontWeight = FontWeight.Normal,
)

val nunitoSansSemiBold18 = TextStyle(
    fontFamily = NunitoSans,
    fontSize = 18.sp,
    lineHeight = 18.sp,
    fontWeight = FontWeight.SemiBold,
)

val nunitoSansBold14 = TextStyle(
    fontFamily = NunitoSans,
    fontSize = 14.sp,
    lineHeight = 14.sp,
    fontWeight = FontWeight.Bold,
)

val nunitoSansBold30 = TextStyle(
    fontFamily = NunitoSans,
    fontSize = 30.sp,
    lineHeight = 30.sp,
    fontWeight = FontWeight.Bold,
)