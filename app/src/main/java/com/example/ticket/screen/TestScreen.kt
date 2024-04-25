package com.example.ticket.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ticket.ui.theme.staticBackgroundCard
import com.example.ticket.ui.theme.staticColorBlack
import com.example.ticket.view.component.text.TextBody

@Composable
fun TestScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {},
        content = {
            TextBody(text = "hello", color = Color.Black)
        }
    )


}