package com.example.quoteapp

import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.Screens.QuestDetail
import com.example.quoteapp.Screens.QuestListItem
import com.example.quoteapp.Screens.QuoteListScreen
import com.example.quoteapp.models.DataManager
import com.example.quoteapp.models.Quote
import com.example.quoteapp.ui.theme.QuoteAppTheme
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //https://www.youtube.com/watch?v=hoi5sSwnCww&list=PLRKyZvuMYSIO9sadcCwR0DR8UPi9bQlev&index=12
        //App flow samjne k liye 10min se dekho

        //iss method se main thread pe load nhi hoga IO thread pe hoga isse multitasking improve hogi and compose m ui bhi  better ki jati h
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsfromFile(applicationContext)
        }
        setContent {
            App()
        }
    }


}
//@Composable
//fun App(){
//    if (DataManager.isDataLoaded.value){
//
//    if (DataManager.CurrentPage.value== Pages.LISTING)
//        QuoteListScreen(data = DataManager.data) {
//        DataManager.switchPages(it)
//        }
//    else{
//        DataManager.currentQuote?.let { QuestDetail(quote = it) }
//    }
//    }
//}
@Composable
fun App(){
    if (DataManager.isDataLoaded.value){

    if (DataManager.CurrentPage.value== Pages.LISTING)
        QuoteListScreen(data = DataManager.data) {
        DataManager.switchPages(it)
        }
    else{
        DataManager.currentQuote?.let { QuestDetail(quote = it) }
    }
    }
}
enum class Pages{
    LISTING,DETAIL
}
