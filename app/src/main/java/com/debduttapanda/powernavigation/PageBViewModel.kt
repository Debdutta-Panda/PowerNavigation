package com.debduttapanda.powernavigation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PageBViewModel: ViewModel() {
    val navigation = mutableStateOf<NavigationCallback?>(null)
    val receivedMoney = mutableStateOf(0)
    val bonus = mutableStateOf(0)
    fun onGoBack() {
        navigation.navigate { navHostController, lifecycleOwner ->
            navHostController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.set("totalReceived",(receivedMoney.value)+(bonus.value))
            navHostController.navigateUp()
        }
    }

    fun setArguments(_receivedMoney: Int?, _bonus: Int?) {
        receivedMoney.value = _receivedMoney?:0
        bonus.value = _bonus?:0
    }
}