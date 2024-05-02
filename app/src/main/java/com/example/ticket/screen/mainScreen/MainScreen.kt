package com.example.ticket.screen.mainScreen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Observer
import com.example.ticket.constant.Constants
import com.example.ticket.model.local.PersonModelLocal
import com.example.ticket.navigation.MainActions
import com.example.ticket.state.GetPersonViewState
import com.example.ticket.util.SharedPreferencesManager
import com.example.ticket.view.component.text.TextBody
import com.example.ticket.viewmodel.MyViewModel

@Composable
fun MainScreen(
    viewModel: MyViewModel,
    action: MainActions
){
    val currentUser = viewModel.currentUser.observeAsState().value
    val currentPerson = viewModel.currentPerson.observeAsState().value

    Scaffold(
        topBar = {
            TopAppBarMainScreen(
                navigationAction = { action.gotoSettingsScreen.invoke() },
                action = {  }, // Действие на кнопку обновить
                text = currentUser?.performerName ?: currentPerson?.performerName ?: "ФИО сотрудника"
            )
        },
        content = {

        }
    )
}

