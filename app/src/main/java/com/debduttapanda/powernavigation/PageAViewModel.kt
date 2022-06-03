package com.debduttapanda.powernavigation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PageAViewModel: ViewModel() {
    val navigation = mutableStateOf<NavigationCallback?>(null)
    val money = mutableStateOf(0)
    val sendBonus = mutableStateOf(false)
    val totalReceived = mutableStateOf(0)
    fun onSendClick() {
        navigation.navigate{navHostController, lifecycleOwner ->
            navHostController
                .currentBackStackEntry
                ?.savedStateHandle
                ?.getLiveData<Int>("totalReceived")
                ?.observe(lifecycleOwner){
                    totalReceived.value = it
                    navHostController
                        .currentBackStackEntry
                        ?.savedStateHandle
                        ?.remove<Int>("totalReceived")
                }
            if(!sendBonus.value){
                navHostController.navigate("page_b/${money.value}")
            }
            else{
                navHostController.navigate("page_b/${money.value}?bonus=50")
            }
        }
    }
}