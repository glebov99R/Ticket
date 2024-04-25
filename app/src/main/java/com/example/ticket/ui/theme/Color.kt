package com.example.ticket.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val focusedBorderEditTextColorLight = Color(0xffb51d4e)
val borderStrokeButtonLight = Color(0xffb51d4e)
val floatingActionButtonColorLight = Color(0xffb51d4e)
val topBarColorLight = Color(0xffb51d4e)
val secondaryTextColorLight = Color(0xFF000000)
val backgroundLazyColumnLight = Color(0xffe7e7e7)
val SwipeRefreshIndicatorLight = Color(0xffb51d4e)
val circularProgressIndicatorColorLight = Color(0xffb51d4e)
val iconDrawerColorLight = Color(0xffb51d4e)
val circularProgressBarLight = Color(0xffb51d4e)
val secondaryBorderLight = Color(0xffb51d4e)
val backgroundTransparentSurfaceLight = Color(0xffe7e7e7)
val backgroundCircularLight = Color(0xffe7e7e7)

val staticColorBlack = Color(0xFF000000)
val StaticWithColor = Color(0xffffffff)
val staticGreyColor = Color(0xFF6A6A68)
val staticCardColor = Color(0xFFE8E1E2)
val staticGreenColor = Color(0xff00a000)

val focusedBorderEditTextColorDark = Color(0xFF410002)
val borderStrokeButtonDark = Color(0xFF410002)
val floatingActionButtonColorDark = Color(0xFF410002)
val topBarColorDark = Color(0xFF410002)
val secondaryTextColorDark = Color(0xFFE8E1E2)
val backgroundLazyColumnDark = Color(0xFF201A1B)
val SwipeRefreshIndicatorDark = Color(0xffffffff)
val circularProgressIndicatorColorDark = Color(0xffffffff)
val iconDrawerColorDark = Color(0xffffffff)
val circularProgressDark = Color(0xffffffff)
val secondaryBorderDark = Color(0xffffffff)
val backgroundTransparentSurfaceDark = Color(0xFF201A1B)
val backgroundCircularDark = Color(0xFF201A1B)



@Composable
fun focusedBorderEditTextColor() = focusedBorderEditTextColorDark orInLightTheme  focusedBorderEditTextColorLight
@Composable
fun borderStrokeButton() = borderStrokeButtonDark orInLightTheme  borderStrokeButtonLight
@Composable
fun floatingActionButtonColor() = floatingActionButtonColorDark orInLightTheme floatingActionButtonColorLight
@Composable
fun topBarColor() = topBarColorDark orInLightTheme topBarColorLight
@Composable
fun secondaryTextColor() = secondaryTextColorDark orInLightTheme secondaryTextColorLight
@Composable
fun backgroundLazyColumn() = backgroundLazyColumnDark orInLightTheme backgroundLazyColumnLight
@Composable
fun swipeRefreshIndicator() = SwipeRefreshIndicatorDark orInLightTheme SwipeRefreshIndicatorLight
@Composable
fun circularProgressIndicatorColor() = circularProgressIndicatorColorDark orInLightTheme circularProgressIndicatorColorLight
@Composable
fun iconDrawerColor() = iconDrawerColorDark orInLightTheme iconDrawerColorLight
@Composable
fun circularProgress() = circularProgressDark orInLightTheme circularProgressBarLight
@Composable
fun secondaryBorder() = secondaryBorderDark orInLightTheme secondaryBorderLight
@Composable
fun backgroundTransparentSurface() = backgroundTransparentSurfaceDark orInLightTheme backgroundTransparentSurfaceLight
@Composable
fun  backgroundCircular() = backgroundCircularDark orInLightTheme backgroundCircularLight