@file:Suppress("UNUSED_EXPRESSION")

package com.example.ticket.screen

import android.annotation.SuppressLint
import android.content.IntentFilter
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.barcode.BarcodeUtility
import com.example.ticket.BuildConfig
import com.example.ticket.R
import com.example.ticket.navigation.MainActions
import com.example.ticket.state.LoginViewState
import com.example.ticket.ui.theme.backgroundLayout
import com.example.ticket.ui.theme.secondaryTextColor
import com.example.ticket.util.BarcodeBroadcastReceiver
import com.example.ticket.util.SharedPreferencesManager
import com.example.ticket.view.component.AlertDialog.LoadingAlertDialog
import com.example.ticket.view.component.AlertDialog.QuestionAlertDialog
import com.example.ticket.view.component.text.TextBody
import com.example.ticket.viewmodel.MyViewModel

@SuppressLint("UnspecifiedRegisterReceiverFlag")
@Composable
fun LoginScreen(
    viewModel: MyViewModel,
    action: MainActions
){
    val context = LocalContext.current
    val requester = remember { FocusRequester() }
    val scannedBarcode = remember { mutableStateOf("") }
    val loginState = viewModel.loginViewState.collectAsState().value
    val barcodeUtility: BarcodeUtility = BarcodeUtility.getInstance()
    val showLoadingDialog = remember { mutableStateOf(true) }
    val sharedPreferenceManager = remember { SharedPreferencesManager(viewModel.context) }

    LaunchedEffect(Unit){
        viewModel.restartBarcodeScanner(context)
        requester.requestFocus()
    }
//0000000007849
    DisposableEffect(Unit) {
        val barcodeBroadcastReceiver = BarcodeBroadcastReceiver { barcodeValue ->
            scannedBarcode.value = barcodeValue
            if (scannedBarcode.value.length > 6) viewModel.authorization(barcodeValue)
        }
        context.registerReceiver(
            barcodeBroadcastReceiver,
            IntentFilter().apply { addAction(BarcodeUtility.SCANNER_BROADCAST_ACTION) } // Регистрирует приемник широковещательного сообщения для получения сканированного значения
        )
        onDispose {
            context.unregisterReceiver(barcodeBroadcastReceiver) // Отменяет регистрацию приемника широковещательного сообщения при уничтожении компонента
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(backgroundLayout())
            .onKeyEvent {
                if (it.nativeKeyEvent.keyCode == 293 && it.type == KeyEventType.KeyDown) {
                    barcodeUtility.startScan(context, BarcodeUtility.ModuleType.BARCODE_2D)
                    true
                } else {
                    false
                }
            }
            .focusRequester(requester)
            .focusable()
            .size(10.dp),
        Alignment.Center
    ) {
        Image(
            painterResource(R.drawable.logo), contentDescription = "",
            Modifier
                .padding(bottom = 150.dp)
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
            Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            TextBody(text = "Нажмите на кнопку SCAN", color = secondaryTextColor(), modifier = Modifier.padding(bottom = 100.dp))
            Text(color = secondaryTextColor(), text = "Версия: ${BuildConfig.VERSION_NAME}")
        }
    }

    when (loginState) {
        is LoginViewState.Idle -> { "(ɔ◔‿◔)ɔ ♥" }

        is LoginViewState.Loading -> {
            LoadingAlertDialog(
                onDismiss = { showLoadingDialog.value },
                textQuestion = "Авторизация...",
                show = showLoadingDialog.value
            )
        }

        is LoginViewState.Success -> {
            barcodeUtility.stopScan(context, BarcodeUtility.ModuleType.BARCODE_2D)
            action.gotoMainScreen.invoke()
        }

        is LoginViewState.Error -> {
            if (loginState.code == 303){
                QuestionAlertDialog(
                    onDismiss = { viewModel.clearLoginViewState() },
                    onConfirm = {
                        sharedPreferenceManager.saveData("barcode_user",scannedBarcode.value)
                        action.gotoMainScreen.invoke()
                        viewModel.clearLoginViewState()
                    },
                    dismissText = "Нет",
                    confirmText = "Да",
                    textQuestion = "Нет подключения к сети, продолжить работу без входа в аккаунт ?"
                )
            } else {
                QuestionAlertDialog(
                    onDismiss = { viewModel.clearLoginViewState() },
                    onConfirm = {
                        barcodeUtility.startScan(context, BarcodeUtility.ModuleType.BARCODE_2D)
                        viewModel.clearLoginViewState()
                                },
                    dismissText = "Нет",
                    confirmText = "Да",
                    textQuestion = "Ошибка ответа от сервера, просканировать пропуск ещё раз ?"
                )
            }
        }
    }

}