package com.debduttapanda.powernavigation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PageBViewModel: ViewModel() {
    val navigationTrigger = mutableStateOf(0L)
    fun onGoBack() {
        navigationTrigger.value = System.currentTimeMillis()
    }

    fun onNavigated() {
        navigationTrigger.value = 0L
    }
}