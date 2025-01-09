package com.aermakova.corgstore.ui.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.aermakova.corgstore.R
import com.aermakova.corgstore.ui.components.Counter
import com.aermakova.corgstore.ui.home.model.ProductUIModel
import com.aermakova.corgstore.ui.theme.AppStrings
import com.aermakova.corgstore.ui.theme.AppTheme
import com.aermakova.corgstore.ui.theme.gelasioRegular24
import com.aermakova.corgstore.ui.theme.nunitoSansBold30
import com.aermakova.corgstore.ui.theme.nunitoSansLight14
import com.aermakova.corgstore.ui.theme.nunitoSansSemiBold18

@Composable
fun ProductScreen() {

}

@Composable
private fun ProductScreenContent(
    product: ProductUIModel
) {
    val isInPreviewMode = LocalInspectionMode.current

    AppTheme {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .background(color = AppTheme.colors.white)
        ) {
            Column {
                Card(
                    shape = RectangleShape,
                    modifier = Modifier
                        .padding(start = AppTheme.dimens.spacing52)
                        .clip(
                            RoundedCornerShape(bottomStart = AppTheme.dimens.roundCornerRadius)
                        )
                        .aspectRatio(3 / 4f)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter(
                            model = product.contextualImageUrl ?: product.image,
                            error = painterResource(R.drawable.product_mock)
                        ).takeIf { !isInPreviewMode } ?: painterResource(R.drawable.product_mock),
                        contentDescription = "product image photo",
                        contentScale = ContentScale.FillBounds
                    )
                }

                Column(
                    modifier = Modifier.padding(
                        horizontal = AppTheme.dimens.spacing24
                    )
                ) {
                    Text(
                        modifier = Modifier.padding(
                            top = AppTheme.dimens.spacing24
                        ),
                        text = product.title,
                        style = gelasioRegular24
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                vertical = AppTheme.dimens.spacing10
                            ),
                            text = "$${product.price}",
                            style = nunitoSansBold30
                        )

                        Counter()
                    }

                    //Rating()

                    Text(

                        textAlign = TextAlign.Justify,
                        text = product.description ?: "",
                        style = nunitoSansLight14
                    )
                }
            }

            Row(
                modifier = Modifier.padding(
                    horizontal = AppTheme.dimens.spacing24,
                    vertical = AppTheme.dimens.spacing20
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(AppTheme.dimens.buttonHeight)
                        .clip(RoundedCornerShape(AppTheme.dimens.counterCornerRadius))
                        .background(color = AppTheme.colors.counterColor)
                        .clickable { }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.favourite_outlined),
                        contentDescription = "save to favourite"
                    )
                }

                Spacer(modifier = Modifier.width(AppTheme.dimens.spacing16))

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(AppTheme.dimens.buttonHeight)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(AppTheme.dimens.counterCornerRadius))
                        .background(color = AppTheme.colors.black)
                        .clickable { }
                ) {
                    Text(
                        text = AppStrings.addToCart,
                        style = nunitoSansSemiBold18.copy(color = AppTheme.colors.white)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ProductScreenContentPreview() {
    AppTheme {
        ProductScreenContent(
            product = ProductUIModel.test
        )
    }
}
