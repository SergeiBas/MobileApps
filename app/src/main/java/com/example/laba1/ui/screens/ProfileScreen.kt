package com.example.laba1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laba1.model.FeedItem
import com.example.laba1.model.NoteItem
import com.example.laba1.model.TaskItem
import com.example.laba1.viewmodel.AppViewModel

@Composable
fun ProfileScreen(viewModel: AppViewModel) {
    val profileStatus by viewModel.profileStatus.collectAsState()
    val feedItems by viewModel.feedItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = profileStatus,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { viewModel.onProfileButtonClick() }) {
            Text("Оновити профіль")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = feedItems, key = { it.id }) { item ->
                when (item) {
                    is TaskItem -> TaskItemCard(item)
                    is NoteItem -> NoteItemCard(item)
                }
            }
        }
    }
}

@Composable
private fun TaskItemCard(item: TaskItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Задача: ${item.title}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = if (item.isCompleted) "Статус: Виконано" else "Статус: В роботі",
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun NoteItemCard(item: NoteItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "Нотатка від ${item.author}",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = item.content,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}