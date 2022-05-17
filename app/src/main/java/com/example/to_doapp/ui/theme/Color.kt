package com.example.to_doapp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpace

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val lowPriorityColor = Color(0xFF00C980)

val LightGrey = Color(0xFFFCFCFC)
val MediumGrey = Color(0xFF9C9C9C)
val DarkGrey = Color(0xFF141414)

val mediumPriorityColor = Color(0xFFFFC114)
val highPriorityColor = Color(0xFFFF4646)
val nonePriorityColor = MediumGrey

val Colors.fabBackgroundColor: Color
    @Composable
    get() = if (isLight) Teal200 else Purple700

val Colors.taskItemTextColor: Color
    @Composable
    get() = if (isLight) DarkGrey else LightGrey

val Colors.splashScreenBackGroundColor: Color
    @Composable
    get() = if (isLight) Purple700 else Color.Black

val Colors.taskItemBackgroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGrey


val Colors.toAppBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else LightGrey
val Colors.toAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple500 else Color.Black