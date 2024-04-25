package com.example.ticket.view.component.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ticket.ui.theme.StaticWithColor
import com.example.ticket.ui.theme.topBarColor
import com.example.ticket.view.component.text.TextTitle

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    text: String
){
    androidx.compose.material.TopAppBar(
        modifier = modifier,
        backgroundColor = topBarColor(),
        title = {
            TextTitle(
                text = text,
                modifier = modifier,
                color = StaticWithColor
            ) },
    )
}