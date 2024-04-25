package com.example.ticket.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val StaticColorTextInAlertDialog  = Color(0xFF000000)
val StaticContentButtonColor = Color(0xffffffff)


val backgroundColorLight = Color(0xffffffff)
val backgroundColorCardLight = Color(0xFFF3D3D8)
val surfaceColorLight = Color(0xffb51d4e)
val topAppBarColorLight = Color(0xffb51d4e)
val buttonBackgroundColorLight = Color(0xffb51d4e)
val buttonContentColorLight = Color(0xffffffff)
val buttonEnabledColorLight = Color(0xff00a000)
val buttonDisabledColorLight = Color(0xffb6bbba)
val dividerColorLight = Color(0xff201a1b)
val outlineTextFieldColorLight = Color(0xffb51d4e)
val primaryTextColorLight = Color(0xff201a1b)

val iconColorLight = Color(0xffffffff)
val iconLayoutLight = Color(0xFF000000)
val backgroundLayoutLight = Color(0xFFFFFFFF)
val barsColorLight = Color(0xFFA20641)
val borderCardColorLight = Color(0xFFA20641)
val textOnLayoutLight = Color(0xFF000000)


////////////////////////////////////////////////////////////////////
val StaticTextColorInCard = Color(0xFF6A6A68)
val StaticTopAppBarIconColor = Color(0xffffffff)
val StaticBackgroundCard = Color(0xFFE8E1E2)
////////////////////////////////////////////////////////////////////

val backgroundColorDark = Color(0xff201a1b)
val backgroundColorCardDark = Color(0xFFFFDDBA)
val surfaceColorDark = Color(0xFF847375)
val topAppBarColorDark = Color(0xFF524345)
val buttonBackgroundColorDark = Color(0xFF524345)
val buttonContentColorDark = Color(0xffffb2be)
val buttonEnabledColorDark = Color(0xff2e8b57)
val buttonDisabledColorDark = Color(0xffc0c0c0)

val dividerColorDark = Color(0xff201a1b)
val outlineTextFieldColorDark = Color(0xffffd9de)
val primaryTextColorDark = Color(0xffffffff)

val iconColorDark = Color(0xffffd9de)
val iconLayoutDark = Color(0xFFFFFFFF)
val backgroundLayoutDark = Color(0xFF201A1B)
val barsColorDark = Color(0xFF410002)
val borderCardColorDark = Color(0xFFFFFFFF)
val textOnLayoutDark = Color(0xFFFFFFFF)

///////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////

/**
 * слева  черный справа белый
 */
@Composable
fun backgroundButtonColor() = barsColorDark orInLightTheme  buttonBackgroundColorLight
/**
 * Получение цвета текста находящегося на фоне выбранной темы
 */
@Composable
fun textOnLayout() = textOnLayoutDark orInLightTheme  textOnLayoutLight

/**
 * Поулчения цвета окантовки элементов
 */
@Composable
fun borderCardColor() = borderCardColorDark orInLightTheme borderCardColorLight

/**
 * Получение цвета баров приложения
 */
@Composable
fun barsColor() = barsColorDark orInLightTheme barsColorLight

/**
 * Получение заднего фона экранов приложения
 */
@Composable
fun backgroundLayout() = backgroundLayoutDark orInLightTheme backgroundLayoutLight

/**
 * Получение цвета икнонок расположенных на экранах
 */
@Composable
fun iconLayout() = iconLayoutDark orInLightTheme iconLayoutLight

/**
 * Получение заднего фона карточек спецификаций и операций
 */
@Composable
fun staticBackgroundCard() = StaticBackgroundCard

/**
 * Получение цвета икнонок верхнего меню-бара
 */
@Composable
fun staticTopAppBarIconColor() = StaticTopAppBarIconColor

/**
 * Получение заднего фона карточки
 */
@Composable
fun staticTextColorInCard() = StaticTextColorInCard

/**
 * Цвет заднего фона
 */
@Composable
fun backgroundColor() = backgroundColorDark orInLightTheme backgroundColorLight

/**
 * Цвет заднего фона элемента списка
 */
@Composable
fun backgroundCardColor() = backgroundColorCardDark orInLightTheme backgroundColorCardLight

/**
 * Цвет материальной поверхности
 */
@Composable
fun surfaceColor() = surfaceColorDark orInLightTheme surfaceColorLight

/**
 * Цвет верхнего меню бара
 */
@Composable
fun topAppBarColor() = topAppBarColorDark orInLightTheme topAppBarColorLight

/**
 * Цвет фона кнопки
 */
@Composable
fun buttonBackgroundColor() = buttonBackgroundColorDark orInLightTheme buttonBackgroundColorLight

/**
 * Цвет контента в кнопке
 */
@Composable
fun buttonContentColor() = buttonContentColorDark orInLightTheme buttonContentColorLight

/**
 *  Цвет активной кнопки
 */
@Composable
fun buttonEnabledColor() = buttonEnabledColorDark orInLightTheme buttonEnabledColorLight

/**
 * Цвет не активной кнопки
 */
@Composable
fun buttonDisabledColor() = buttonDisabledColorDark orInLightTheme buttonDisabledColorLight


/**
 * Цвет разделяющей линии
 */
@Composable
fun dividerColor() = barsColorDark orInLightTheme buttonEnabledColorLight

/**
 * Цвет окантовки в текстовом поле ввода
 */
@Composable
fun outlineTextFieldColor() = outlineTextFieldColorDark orInLightTheme outlineTextFieldColorLight

/**
 * Цвет основого текста
 */
@Composable
fun primaryTextColor() = primaryTextColorDark orInLightTheme primaryTextColorLight



/**
 * Цвет иконок
 */
@Composable
fun iconColor() = iconColorDark orInLightTheme iconColorLight


private fun Color.Companion.fromRGB(rgb: String) = Color(android.graphics.Color.parseColor(rgb))


@SuppressLint("ConflictingOnColor")
val AppLightColors = lightColors(
    primary = surfaceColorLight,
    primaryVariant = backgroundLazyColumnLight,
    secondary = surfaceColorLight,
    secondaryVariant =  surfaceColorLight,
    background = backgroundLazyColumnLight,
    surface = backgroundLazyColumnLight,
    onPrimary = buttonContentColorLight,
    onSecondary = dividerColorLight,
    onBackground = dividerColorLight,
    onSurface = dividerColorLight
)

@SuppressLint("ConflictingOnColor")
val AppDarkColors = darkColors(
    primary = topAppBarColorDark,
    primaryVariant = backgroundColorDark,
    secondary = backgroundColorCardDark,
    secondaryVariant = topAppBarColorDark,
    background = backgroundColorDark,
    surface = backgroundColorDark,
    onPrimary = backgroundColorDark,
    onSecondary = backgroundColorDark,
    onBackground = backgroundColorDark,
    onSurface = backgroundColorDark
)