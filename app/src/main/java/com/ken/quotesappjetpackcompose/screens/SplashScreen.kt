package com.ken.quotesappjetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ken.quotesappjetpackcompose.R
import kotlinx.coroutines.delay

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreen(
    onTimeout: () -> Unit,
) {
    // Display the splash screen for 3 seconds
    LaunchedEffect(Unit) {
        delay(3000L)
        onTimeout()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(
            brush = Background()
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo), // Replace with your logo resource
                contentDescription = "Splash Logo",
                modifier = Modifier.size(300.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Welcome to Quotes App",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }
    }
}