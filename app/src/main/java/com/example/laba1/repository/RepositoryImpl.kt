package com.example.laba1.repository

import com.example.laba1.model.FeedItem
import com.example.laba1.model.NoteItem
import com.example.laba1.model.TaskItem

class AppRepositoryImpl : AppRepository {
    override fun getFeedItems(): List<FeedItem> = listOf(
        TaskItem(id = 1, title = "Налаштувати навігацію", isCompleted = true),
        NoteItem(id = 2, author = "Сергій", content = "Перевірити список на ProfileScreen"),
        TaskItem(id = 3, title = "Додати різні картки для моделей", isCompleted = true),
        NoteItem(id = 4, author = "Нотатка", content = "LazyColumn займає весь вільний простір"),
        TaskItem(id = 5, title = "Запустити на емуляторі", isCompleted = false)
    )
}