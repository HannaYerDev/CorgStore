package com.aermakova.corgstore.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntSize
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.aermakova.corgstore.ui.theme.AppTheme

@Composable
fun ShimmerImage(
    imageUrl: String?,
    @DrawableRes errorImage: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        error = painterResource(errorImage),
    )

    val isLoading = painter.state is AsyncImagePainter.State.Loading

    var boxSize by remember { mutableStateOf(IntSize.Zero) }

    Box(modifier = modifier.onGloballyPositioned { boxSize = it.size }) {
        if (isLoading) {
            ShimmerEffect(modifier = Modifier.matchParentSize(),
                widthPx = boxSize.width,
                heightPx = boxSize.height
            )
        }

        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    }
}

@Composable
fun ShimmerEffect(
    modifier: Modifier = Modifier,
    widthPx: Int,
    heightPx: Int,
) {
    val shimmerColors = listOf(
        AppTheme.colors.light.copy(alpha = 0.2f),
        AppTheme.colors.light.copy(alpha = 0.05f),
        AppTheme.colors.light.copy(alpha = 0.2f)
    )

    val gradientWidth: Float = (0.4f * heightPx)

    val transition = rememberInfiniteTransition(label = "")

    val xShimmer by transition.animateFloat(
        initialValue = 0f,
        targetValue = (widthPx + gradientWidth),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1300,
                easing = LinearEasing,
                delayMillis = 300
            ),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val yShimmer by transition.animateFloat(
        initialValue = 0f,
        targetValue = (heightPx + gradientWidth),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1300,
                easing = LinearEasing,
                delayMillis = 300
            ),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(xShimmer - gradientWidth, yShimmer - gradientWidth),
        end = Offset(xShimmer, yShimmer)
    )


    Box(
        modifier = modifier
            .background(brush = brush)
    )
}