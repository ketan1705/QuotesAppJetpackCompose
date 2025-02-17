package com.ken.quotesappjetpackcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun Background(): Brush {
    return Brush.linearGradient(
        colors = listOf(
            Color(0xFFE3F2FD),
            Color(0xFF000000)
        )
    )
}