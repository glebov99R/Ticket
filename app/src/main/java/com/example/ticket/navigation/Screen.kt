package com.example.ticket.navigation

sealed class Screen(val route: String) {

    object Login: Screen("login")
    object MainScreen: Screen("main")

}