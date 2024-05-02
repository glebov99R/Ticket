package com.example.ticket.screen.testScreen

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.ticket.model.local.PersonModelLocal
import com.example.ticket.state.GetPersonViewState
import com.example.ticket.util.SharedPreferencesManager
import com.example.ticket.view.component.text.TextBody
import com.example.ticket.viewmodel.MyViewModel

@Composable
fun TestScreen(
    viewModel: MyViewModel
){
    val sharedPreferenceManager = remember { SharedPreferencesManager(viewModel.context) }
    var inputValue by remember { mutableStateOf("") }
    val savedValue by rememberUpdatedState(inputValue)

    val personList = viewModel.getPersonViewState.collectAsState().value

    val currentPerson = viewModel.currentPerson.observeAsState().value

    val personListAll = viewModel.allPersonListFromLocalDb.observeAsState(listOf()).value


    LaunchedEffect(Unit) {
        viewModel.getPeron()
    }

    TextBody(text = sharedPreferenceManager.getData("barcode_user",savedValue), color = Color.Black)

    LazyColumn {

    }

    when(personList){
        is GetPersonViewState.Idle -> {}
        is GetPersonViewState.Loading -> {}
        is GetPersonViewState.Success -> {

//            LazyColumn(modifier = Modifier.fillMaxSize()) {
//                items(personList.items){ items ->
//                    PersonItem(item = items)
//
//                }
//            }
//            LazyColumn(modifier = Modifier.fillMaxSize()) {
//                items(personListAll){ items ->
//                    Log.d("items",items.pfBarcode.toString())
//                    PersonItem(item = items)
//                }
//            }
            Button(onClick = {
                viewModel.fetchPersonFromBarcode(sharedPreferenceManager.getData("barcode_user",savedValue))
            }) {

            }

            currentPerson?.let { Log.d("test_person", it.performerName) }

        }
        is GetPersonViewState.Error -> {}
    }
}

@Composable
fun PersonItem(item: PersonModelLocal){
    TextBody(text = item.performerName, color = Color.Black)
    TextBody(text = item.extSector.toString(), color = Color.Black)
    TextBody(text = item.performerId.toString(), color = Color.Black)
    TextBody(text = item.pfBarcode.toString(), color = Color.Black)
}