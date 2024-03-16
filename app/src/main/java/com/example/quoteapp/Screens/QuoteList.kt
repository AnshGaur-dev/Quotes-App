package com.example.quoteapp.Screens

import android.media.session.MediaSession.QueueItem
import android.provider.ContactsContract.RawContacts.Data
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quoteapp.models.Quote

@Composable
fun QueueList(data: Array<Quote>,onClick:(quote:Quote)->Unit){
    
    LazyColumn(content = {
        items(data){
            QuestListItem(quote = it,onClick)
        }
    })
}

