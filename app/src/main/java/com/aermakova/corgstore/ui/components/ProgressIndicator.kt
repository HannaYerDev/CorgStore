package com.aermakova.corgstore.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = "Progress Indicator" }
            .clickable { /* Disable clicks */ },
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}