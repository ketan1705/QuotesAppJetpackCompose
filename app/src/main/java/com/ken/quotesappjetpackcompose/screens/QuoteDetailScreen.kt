package com.ken.quotesappjetpackcompose.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ken.quotesappjetpackcompose.DataManager
import com.ken.quotesappjetpackcompose.models.Quotes


@Composable
fun QuoteDetailScreen(quote: Quotes) {

    BackHandler()
    {
        DataManager.switchPages(null)
    }
    Box(
        modifier = Modifier.fillMaxSize(1f)
            .background(
                brush = Background()
            )
    ) {
        Column(Modifier.padding(top = 30.dp))
        {
            QuoteDetailHeader()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(1f)
            ) {
                Card(
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(4.dp),
                    modifier = Modifier.padding(32.dp).fillMaxWidth()
                )
                {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(16.dp, 24.dp)
                    ) {

                        Image(
                            imageVector = Icons.Filled.FormatQuote,
                            contentDescription = "Quote",
                            modifier = Modifier.size(80.dp).rotate(180F)
                        )
                        Text(
                            quote.title,
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            quote.author,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }

}