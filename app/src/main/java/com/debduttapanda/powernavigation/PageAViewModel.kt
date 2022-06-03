package com.debduttapanda.powernavigation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PageAViewModel: ViewModel() {
    val money = mutableStateOf(0)
    val sendBonus = mutableStateOf(false)
    val navigationTrigger = mutableStateOf(0L)
    fun onSendClick() {
        navigationTrigger.value = System.currentTimeMillis()
    }

    fun onNavigated() {
        navigationTrigger.value = 0L
    }
}