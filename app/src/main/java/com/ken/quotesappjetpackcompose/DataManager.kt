package com.ken.quotesappjetpackcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.ken.quotesappjetpackcompose.models.Quotes

object DataManager {

    var data = emptyArray<Quotes>()
    var currentQuote: Quotes? = null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quotes>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quotes: Quotes?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quotes
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}