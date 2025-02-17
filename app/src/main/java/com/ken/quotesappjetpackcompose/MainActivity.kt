package com.ken.quotesappjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ken.quotesappjetpackcompose.screens.QuoteDetailScreen
import com.ken.quotesappjetpackcompose.screens.QuoteListScreen
import com.ken.quotesappjetpackcompose.screens.SplashScreen
import com.ken.quotesappjetpackcompose.ui.theme.QuotesAppJetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            QuotesAppJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun MyApp(modifier: Modifier = Modifier) {
    var showSplash by remember {
        mutableStateOf(true)
    }
    if (showSplash) {
        SplashScreen(onTimeout = {
            showSplash = false
        })
    } else {
        if (DataManager.isDataLoaded.value) {
            if (DataManager.currentPage.value == Pages.LISTING) {

                QuoteListScreen(data = DataManager.data) {
                    DataManager.switchPages(it)
                }
            } else {
                DataManager.currentQuote?.let { QuoteDetailScreen(quote = it) }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier.fillMaxSize(1f)
            ) {
                Text(
                    "Loading...",
                    style = MaterialTheme.typography.headlineSmall
                )
            }

        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}

