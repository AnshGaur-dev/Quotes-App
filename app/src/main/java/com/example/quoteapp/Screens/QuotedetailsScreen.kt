package com.example.quoteapp.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.R
import com.example.quoteapp.models.DataManager
import com.example.quoteapp.models.Quote

@Composable
fun QuestDetail(quote: Quote) {
BackHandler {
    DataManager.switchPages(null    )
}
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xfff5ebe0),
                        Color(0xffd5bdaf)
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Row (Modifier.padding(16.dp)){
                Image(
                    painter = painterResource(id = R.drawable.quote),
//                imageVector=Icons.Filled.Favorite, //yeah by default kuch images deta h compose
                    contentDescription = "",
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .size(50.dp)
                    ,
                    colorFilter = ColorFilter.tint(Color.Black)// isse cross ka color decide hua
                )
                Spacer(modifier = Modifier.padding(4.dp)) // isse image and column k beech m space ho jayega
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = quote.text,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp),
                        fontFamily = FontFamily(Font(R.font.mon))

                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = quote.author, modifier = Modifier.padding(top = 4.dp), fontWeight = FontWeight.Thin )
                }
            }
        }

    }
}
