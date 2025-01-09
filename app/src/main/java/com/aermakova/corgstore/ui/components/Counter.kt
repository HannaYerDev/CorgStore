package com.aermakova.corgstore.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.theme.AppTheme
import com.aermakova.corgstore.ui.theme.nunitoSansSemiBold18

@Composable
fun Counter() {
    AppTheme {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            UpdateQuantityButton(
                icon = R.drawable.ic_add
            ) { }

            Text(
                modifier = Modifier.padding(horizontal = AppTheme.dimens.spacing16),
                text = "01",
                style = nunitoSansSemiBold18
            )

            UpdateQuantityButton(
                icon = R.drawable.ic_substruct
            ) { }
        }
    }
}

@Composable
private fun UpdateQuantityButton(
    @DrawableRes icon: Int,
    enable: Boolean = true,
    action: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(AppTheme.dimens.counterSize)
            .clip(RoundedCornerShape(AppTheme.dimens.counterCornerRadius))
            .background(color = AppTheme.colors.counterColor)
            .clickable { action() }
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "change quantity"
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun CounterPreview() {
    AppTheme {
        Counter()
    }
}
