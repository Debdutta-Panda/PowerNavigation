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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.debduttapanda.powernavigation.ui.theme.PowerNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pageAViewModel: PageAViewModel by viewModels()
        val pageBViewModel: PageBViewModel by viewModels()
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
                            ),
                            deepLinks = listOf(
                                navDeepLink {
                                    uriPattern = "https://powernavigation.debduttapanda.com/{money}?bonus={bonus}"
                                },
                                navDeepLink {
                                    uriPattern = "powernavigation://powernavigation.debduttapanda.com/{money}?bonus={bonus}"
                                }
                            )
                        ){backStackEntry->
                            PageB(
                                navController,
                                pageBViewModel,
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


