package com.debduttapanda.powernavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                            "page_b"
                        ){
                            PageB(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PageA(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            "Page A",
            color = Color(0xfff44336),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {
                navController.navigate("page_b")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xfff44336),
                contentColor = Color.White
            )
        ) {
            Text("Go to Page B")
        }
    }
}
@Composable
fun PageB(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            "Page B",
            color = Color(0xfff44336),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {
                //navController.navigate("page_a")//not good to go back
                navController.navigateUp()//use navigateUp instead
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xfff44336),
                contentColor = Color.White
            )
        ) {
            Text("Go back to Page A")
        }
    }
}