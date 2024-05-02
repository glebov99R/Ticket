package com.example.ticket.screen.settingsScreen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.ticket.navigation.MainActions
import com.example.ticket.viewmodel.MyViewModel

@Composable
fun SettingsScreen(
    viewModel: MyViewModel,
    action: MainActions
){
    Scaffold(
        topBar = {
                 TopAppBarSettingsScreen(
                     action = { action.popBackStack.invoke() },
                     text = "Настройки"
                 )
        },
        content = {

        }
    )
}