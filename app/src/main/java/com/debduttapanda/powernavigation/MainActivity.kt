package com.debduttapanda.powernavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.debduttapanda.powernavigation.ui.theme.PowerNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PowerNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "page_a"){
                        composable(
                            "page_a"
                        ){
                            PageA(navController)
                        }
                        composable(
                            "page_b/{money}?bonus={bonus}",
                            arguments = listOf(
                                navArgument("money"){
                                    type = NavType.IntType
                                },
                                navArgument("bonus"){
                                    type = NavType.IntType
                                    defaultValue = 0
                                }
                            )
                        ){backStackEntry->
                            PageB(
                                navController,
                                backStackEntry.arguments?.getInt("money"),
                                backStackEntry.arguments?.getInt("bonus"),
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PageA(navController: NavHostController) {
    var money by remember { mutableStateOf(0) }
    var sendBonus by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = money.toString(),
            onValueChange = {
                try {
                    money = it.toInt()
                } catch (e: Exception) {
                    money = 0
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
                checked = sendBonus,
                onCheckedChange = {
                    sendBonus = it
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
                if(!sendBonus){
                    navController.navigate("page_b/$money")
                }
                else{
                    navController.navigate("page_b/$money?bonus=50")
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xfff44336),
                contentColor = Color.White
            )
        ) {
            Text("Send Money")
        }
    }
}
@Composable
fun PageB(navController: NavHostController, receivedMoney: Int?, bonus: Int?) {
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
                navController.navigateUp()
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