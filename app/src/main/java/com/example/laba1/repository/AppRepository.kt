package com.example.laba1.repository

import com.example.laba1.model.FeedItem

interface AppRepository {
    fun getFeedItems(): List<FeedItem>
}