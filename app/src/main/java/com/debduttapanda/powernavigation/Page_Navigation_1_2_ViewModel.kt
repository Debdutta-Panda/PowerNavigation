package com.debduttapanda.powernavigation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class Page_Navigation_1_2_ViewModel: ViewModel() {
    val navigation = mutableStateOf<NavigationCallback?>(null)
    fun onGoBack() {
        navigation.navigate { navHostController, lifecycleOwner ->
            navHostController.navigateUp()
        }
    }
}