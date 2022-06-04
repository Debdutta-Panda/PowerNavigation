package com.debduttapanda.powernavigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
public fun Section1() {
        val navController = rememberAnimatedNavController()
        AnimatedNavHost(navController = navController, startDestination = "page_a1"){
            composable(
                "page_a1",
                enterTransition = {
                    slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
                },
                popEnterTransition = {
                    slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
                },
                popExitTransition = {
                    slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
                }
            ){
                PageA(navController)
            }
            composable(
                "page_b1",
                enterTransition = {
                    slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(700))
                },
                popEnterTransition = {
                    slideIntoContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
                },
                popExitTransition = {
                    slideOutOfContainer(AnimatedContentScope.SlideDirection.Right, animationSpec = tween(700))
                }
            ){
                PageB(navController)
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
            "Page A1",
            color = Color(0xfff44336),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = {
                navController.navigate("page_b1")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xfff44336),
                contentColor = Color.White
            )
        ) {
            Text("Go to Page B1")
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
            "Page B1",
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
            Text("Go back to Page A1")
        }
    }
}