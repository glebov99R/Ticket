package com.example.ticket.screen.settingsScreen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ticket.R
import com.example.ticket.ui.theme.StaticWithColor
import com.example.ticket.ui.theme.topBarColor
import com.example.ticket.view.component.text.TextTitle

@Composable
fun TopAppBarSettingsScreen(
    modifier: Modifier = Modifier,
    action:() -> Unit,
    text: String
){
    TopAppBar(
        modifier = modifier,
        backgroundColor = topBarColor(),
        title = { TextTitle(text = text, color = StaticWithColor ) },
        navigationIcon = {
            IconButton(onClick = { action() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                    contentDescription = "",
                    tint = StaticWithColor
                )
            }
        }
    )
}