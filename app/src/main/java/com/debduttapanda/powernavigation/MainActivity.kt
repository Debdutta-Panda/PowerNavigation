package com.debduttapanda.powernavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.debduttapanda.powernavigation.ui.theme.PowerNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pageAViewModel: PageAViewModel by viewModels()
        val page_Navigation_1_1_ViewModel: Page_Navigation_1_1_ViewModel by viewModels()
        val page_Navigation_1_2_ViewModel: Page_Navigation_1_2_ViewModel by viewModels()
        setContent {
            PowerNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text(
                        "With MVVM",
                        fontSize = 24.sp,
                        color = Color(0xfff44336),
                        fontWeight = FontWeight.Bold
                    )
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "page_a"){
                        composable(
                            "page_a"
                        ){
                            PageA(navController,pageAViewModel)
                        }
                        navigation(
                            route = "nested_navigation",
                            startDestination = "nested_nav_1_1"
                        ){
                            composable(
                                "nested_nav_1_1"
                            ){backStackEntry->
                                Page_Navigation_1_1(
                                    navController,
                                    page_Navigation_1_1_ViewModel
                                )
                            }
                            composable(
                                "nested_nav_1_2"
                            ){backStackEntry->
                                Page_Navigation_1_2(
                                    navController,
                                    page_Navigation_1_2_ViewModel
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


