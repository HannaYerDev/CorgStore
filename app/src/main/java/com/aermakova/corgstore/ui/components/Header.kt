package com.aermakova.corgstore.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.theme.AppTheme

@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(AppTheme.dimens.dividerHeight)
                .background(color = AppTheme.colors.headerColor)
        )
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier

                    .padding(horizontal = AppTheme.dimens.spacing20),
                painter = painterResource(R.drawable.logo),
                contentDescription = "app logo",
                contentScale = ContentScale.FillBounds
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .height(AppTheme.dimens.dividerHeight)
                .background(color = AppTheme.colors.headerColor)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    AppTheme {
        Header()
    }
}