package com.example.laba1.model

data class TaskItem(
    override val id: Int,
    val title: String,
    val isCompleted: Boolean
) : FeedItem