package com.debduttapanda.powernavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PageB(
    navController: NavHostController,
    pageBViewModel: PageBViewModel,
    receivedMoney: Int?,
    bonus: Int?
) {
    LaunchedEffect(key1 = pageBViewModel.navigationTrigger.value){
        if(pageBViewModel.navigationTrigger.value==0L){
            return@LaunchedEffect
        }
        navController
            .previousBackStackEntry
            ?.savedStateHandle
            ?.set("totalReceived",(receivedMoney?:0)+(bonus?:0))
        navController.navigateUp()
        pageBViewModel.onNavigated()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            "Page B: received money $receivedMoney ${if((bonus?:0)>0) "got $bonus bonus" else "): no bonus this month"}",
            color = Color(0xfff44336),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {
                pageBViewModel.onGoBack()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xfff44336),
                contentColor = Color.White
            )
        ) {
            Text("Go back and pay me again")
        }
    }
}