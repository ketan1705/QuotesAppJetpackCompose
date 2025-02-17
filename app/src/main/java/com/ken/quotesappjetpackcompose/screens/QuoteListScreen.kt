package com.ken.quotesappjetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ken.quotesappjetpackcompose.models.Quotes

@Composable
fun QuoteListScreen(data: Array<Quotes>, onClick: (quote: Quotes) -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(1f)
            .background(
                brush = Background()
            )
    ) {
        Column(Modifier.padding(top = 30.dp))
        {
            Text(
                "Quotes App",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1f).padding(8.dp, 24.dp),
                style = MaterialTheme.typography.headlineMedium
            )
            QuoteList(data = data, onClick)

        }
    }
}