package com.debduttapanda.powernavigation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PageAViewModel: ViewModel() {
    val navigation = mutableStateOf<NavigationCallback?>(null)
    fun onSendClick() {
        navigation.navigate{navHostController, lifecycleOwner ->
            navHostController.navigate("nested_navigation")
        }
    }
}