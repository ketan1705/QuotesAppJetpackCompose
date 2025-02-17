package com.ken.quotesappjetpackcompose.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ken.quotesappjetpackcompose.DataManager


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuoteDetailHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp, 20.dp)
    ) {
        IconButton(
            onClick = {
                DataManager.switchPages(null)
            },
        )
        {
            Icon(
                Icons.Filled.ArrowBackIosNew, contentDescription = "Back",
            )
        }
        Text(
            "Quote Details",
            modifier = Modifier.padding(8.dp, 0.dp),
            style = MaterialTheme.typography.headlineMedium
        )
    }
}