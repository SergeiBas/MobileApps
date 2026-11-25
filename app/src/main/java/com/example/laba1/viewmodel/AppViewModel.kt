package com.example.laba1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.laba1.model.FeedItem
import com.example.laba1.repository.AppRepository
import com.example.laba1.repository.AppRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppViewModel : ViewModel() {

    private val repository: AppRepository = AppRepositoryImpl()

    val homeClickCount : StateFlow<Int>
        field = MutableStateFlow(0)

    val homeMessage : StateFlow<String>
        field = MutableStateFlow("Головний екран (Home)")

    fun onHomeButtonClick() {
        homeClickCount.value++
        homeMessage.value = "Текст змінено через ViewModel!"
    }

    val profileStatus : StateFlow<String>
        field = MutableStateFlow("Профіль користувача: Неактивний")
    fun onProfileButtonClick() {
        profileStatus.value = "Статус: Профіль оновлено!"
    }

    val settingsText : StateFlow<String>
        field = MutableStateFlow("Поточні налаштування: Стандартні")

    fun onSettingsButtonClick() {
        settingsText.value = "Налаштування застосовано!"
    }

    val feedItems : StateFlow<List<FeedItem>>
        field = MutableStateFlow(repository.getFeedItems())
}