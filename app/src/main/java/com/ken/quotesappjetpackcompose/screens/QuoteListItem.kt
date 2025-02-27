package com.ken.quotesappjetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ken.quotesappjetpackcompose.models.Quotes


@Composable
fun QuoteListItem(quote: Quotes, onClick: (quote: Quotes) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp)
            .clickable {
                onClick(quote)
            }
    )
    {
        Row(
            modifier = Modifier.padding(16.dp)
        )
        {
            Image(
                Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(
                    Color.White
                ),
                alignment = Alignment.TopStart,
                contentDescription = "Favorite",
                modifier = Modifier.size(40.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            Spacer(Modifier.padding(4.dp))
            Column(Modifier.weight(1f))
            {
                Text(
                    quote.title,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Box(Modifier.fillMaxWidth(.4f).height(1.dp).background(Color(0xFFEEEEEE)))
                Text(
                    quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
