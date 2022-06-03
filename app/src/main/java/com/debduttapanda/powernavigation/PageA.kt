package com.debduttapanda.powernavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PageA(navController: NavHostController, pageAViewModel: PageAViewModel) {
    val owner = LocalLifecycleOwner.current
    LaunchedEffect(key1 = pageAViewModel.navigation.value){
        pageAViewModel.navigation.forward(navController,owner)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = pageAViewModel.money.value.toString(),
            onValueChange = {
                try {
                    pageAViewModel.money.value = it.toInt()
                } catch (e: Exception) {
                    pageAViewModel.money.value = 0
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Bonus")
            Checkbox(
                checked = pageAViewModel.sendBonus.value,
                onCheckedChange = {
                    pageAViewModel.sendBonus.value = it
                }
            )
        }

        Text(
            "Page A: Send Money",
            color = Color(0xfff44336),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )


        Button(
            onClick = {
                pageAViewModel.onSendClick()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xfff44336),
                contentColor = Color.White
            )
        ) {
            Text("Send Money")
        }
        if((pageAViewModel.totalReceived.value)>0){
            Text("Acknowledgement of ${pageAViewModel.totalReceived.value} received")
        }
    }
}