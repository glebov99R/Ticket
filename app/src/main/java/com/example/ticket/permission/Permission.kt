package com.example.ticket.permission

import android.Manifest
import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState

/**
 * Функция возвращает false в слушчает если разрешение запрещено
 */
@ExperimentalPermissionsApi
fun PermissionState.isPermanentlyDenied(): Boolean{
    return !shouldShowRationale && !hasPermission
}

/**
 * Запуск запросов на разрешения (Permission)
 */
@ExperimentalPermissionsApi
@Composable
fun StartPermission(){
    /**
     * Создаём список из Разрешений прописанных в Manifest
     */
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
        )
    )

    /**
     * Запуск проверки наличия разрешений(Permissions)
     */
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(
        key1 = lifecycleOwner,
        effect = {
            val observer = LifecycleEventObserver{ _ , event ->
                if(event == Lifecycle.Event.ON_RESUME){
                    permissionState.launchMultiplePermissionRequest()
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)

            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        }
    )
    /**
     * Создание визуальной части запроса разрешений и запуск перебора состояний разрешений
     */
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionState.permissions.forEach { perm ->
            when (perm.permission) {
                Manifest.permission.CAMERA -> {
                    when {
                        perm.hasPermission -> { }

                        perm.shouldShowRationale -> {

                            ChekPermission(context = LocalContext.current)
                        }
                        perm.isPermanentlyDenied() -> {

                            repeat(1) {
                                mToast(context = LocalContext.current)
                            }
                        }
                    }
                }
                Manifest.permission.READ_PHONE_STATE -> {
                    when {
                        perm.hasPermission -> { }

                        perm.shouldShowRationale -> {

                            ChekPermission(context = LocalContext.current)
                        }
                        perm.isPermanentlyDenied() -> {

                            repeat(1) {
                                mToast(context = LocalContext.current)
                            }
                        }
                    }
                }
                Manifest.permission.WRITE_EXTERNAL_STORAGE -> {
                    when {
                        perm.hasPermission -> { }

                        perm.shouldShowRationale -> {
                            ChekPermission(context = LocalContext.current)
                        }
                        perm.isPermanentlyDenied() -> {
                            repeat(1) {
                                mToast(context = LocalContext.current)
                            }

                        }
                    }
                }
            }
        }
    }
}

/**
 * Вывод сообщения пользователю при старте программы
 */
@Composable
fun mToast(context: Context){
    Toast.makeText(context, "Для начала работы необходимо дать все разрешения", Toast.LENGTH_SHORT).show()
}

/**
 * Закрывает программу если разрешения не даны пользователем
 */
@Composable
fun ChekPermission(context: Context) {
    Toast.makeText(context, "Необходимо дать все разрешения", Toast.LENGTH_LONG).show()
    val activity = (LocalContext.current as? Activity) // as? Если функция LocalContext.current является типом Activity то вернётся она сама а если нет то будет null
    activity?.finish()
}