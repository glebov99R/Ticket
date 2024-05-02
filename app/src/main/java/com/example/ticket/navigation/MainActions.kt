package com.example.ticket.navigation

import androidx.navigation.NavController

class MainActions(navController: NavController) {

    val popBackStack: () -> Unit = {
        navController.popBackStack()
    }

    val gotoMainScreen: () -> Unit = {
        navController.navigate(Screen.MainScreen.route)
    }

    val gotoSettingsScreen: () -> Unit = {
        navController.navigate(Screen.SettingsScreen.route)
    }

//    val gotoResultScreen: (result: String) -> Unit = { result ->
//        navController.navigate("${Screen.Result.route}/${result}")
//    }



}