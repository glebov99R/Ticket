package com.example.ticket.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.ticket.dataStore
import com.example.ticket.viewmodel.ThemeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {

    val context = LocalContext.current // получение  контекста приложения

    /**
     * viewModelTheme экземляр класса ThemeViewModel
     * который хранит состояния ThemeViewModel
     * в данном контексте
     */
    val viewModelTheme = remember { ThemeViewModel(context.dataStore) }

    /**
     * stateTheme предназначен для,остелживания состояни viewModelTheme
     * при его изменении будет вызвана функция
     * получения варианта использования темы в приложении
     */
    val stateTheme = viewModelTheme.stateSelectedThemeCurrent.observeAsState()

    /**
     * Если value == null это означает что
     * тема приложения будет соответствовать системной
     */
    val value = stateTheme.value ?: isSystemInDarkTheme()

    /**
     *Функция сработает кадый раз при изменений состояния viewModelTheme
     */
    LaunchedEffect(viewModelTheme) { viewModelTheme.request() }

    /**
     * System UI Controller предоставляет простые в использовании утилиты
     * для обновления цветов панели System UI в Jetpack Compose.
     */
    val systemUiController = rememberSystemUiController()

//    val useDarkIcons = !isSystemInDarkTheme() //можно сделать иконки статус бара чёрными в светлой теме системы

    /**
     * Выбор цвета систем бара в соответсвии с текущей темой приложения
     */
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if(value) Color(0xFF410002) else Color(0xffb51d4e),
            darkIcons = false
        )
    }

    /**
     * Записываем в DarkThemeValue новое значение,
     * которое показывает выбранный режим реализации темы
     */
    DarkThemeValue.current.value = value

    /**
     * Если value == false - Использовать тёмную тему else - светлую
     */
    MaterialTheme(
        colors = if (value) AppDarkColors else AppLightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}

/**
 *  isDarkTheme функция получения текущего значения выбора варианта реализации темы
 */
@Composable
@ReadOnlyComposable
fun isDarkTheme() = DarkThemeValue.current.value

/**
 *  C помощью функции-билдера compositionLocalOf
 * мы создаем объект класса CompositionLocal (DarkThemeValue)
 *  и записываем в него наблюдателя за переменной типа Boolean
 */
@SuppressLint("CompositionLocalNaming")
private val DarkThemeValue = compositionLocalOf { mutableStateOf(false) }

/**
 * orInLightTheme — это просто причудливая функция, позволяющая не писать if/else.
 * infix функция должна
 * 1) Быть функцие расширения
 * 2) Должна иметь 1 параметр
 * 3) Не должна иметь переменное количество аргументов
 */
@Composable
@ReadOnlyComposable
infix fun <T> T.orInLightTheme(other: T): T = if (isDarkTheme()) this else other