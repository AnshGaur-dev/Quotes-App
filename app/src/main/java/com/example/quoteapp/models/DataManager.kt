package com.example.quoteapp.models

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quoteapp.Pages
import com.google.gson.Gson
import java.nio.charset.Charset

//object banane se hum direct methods ko acess kar sakte h
object DataManager {
    var currentQuote:Quote?=null
    var isDataLoaded= mutableStateOf(false)
    //Quote type ki empty array banani h
    var data= emptyArray<Quote>()
    var CurrentPage= mutableStateOf(Pages.LISTING)
    fun loadAssetsfromFile(context: Context){
        val inputStream=context.assets.open("quotes.json")
        val  size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer, Charsets.UTF_8)
        val gson= Gson()//Json ko kotlin yah java objects m convert karne k liye use karte h
        data=gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value=true
    }
    fun switchPages(quote: Quote?){
        if (CurrentPage.value==Pages.LISTING){
             currentQuote=quote
            CurrentPage.value=Pages.DETAIL
        }
        else{
            CurrentPage.value=Pages.LISTING
        }
    }

}