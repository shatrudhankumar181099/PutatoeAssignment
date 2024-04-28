package com.example.putatoe.nvigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.putatoe.LoginScreen
import com.example.putatoe.SignUpScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = Screen.LoginScreen.route ){
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(
            route = Screen.SignUpScreen.route
        ){
            SignUpScreen(navController)
        }
    }
}