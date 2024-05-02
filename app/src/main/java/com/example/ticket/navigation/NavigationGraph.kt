package com.example.ticket.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ticket.screen.loginScreen.LoginScreen
import com.example.ticket.screen.mainScreen.MainScreen
import com.example.ticket.screen.settingsScreen.SettingsScreen
import com.example.ticket.viewmodel.MyViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalAnimationApi
@Composable
fun NavigationGraph(
    viewModel: MyViewModel = hiltViewModel()
){
    val navController = rememberAnimatedNavController()
    val action = remember(navController) { MainActions(navController) }

    AnimatedNavHost(navController = navController, startDestination = Screen.Login.route) {

        composable(Screen.Login.route){
            LoginScreen(viewModel,action)
        }

        composable(Screen.MainScreen.route){
            MainScreen(viewModel, action)
        }

        composable(Screen.SettingsScreen.route){
            SettingsScreen(viewModel, action)
        }

//        composable("${Screen.Result.route}/{result}"){
//            val result = it.arguments?.getString("result")
//            ResultScreen(viewModel, result = result, action)
//        }
//

    }
}