package com.example.laba1.model

data class NoteItem(
    override val id: Int,
    val author: String,
    val content: String
) : FeedItem