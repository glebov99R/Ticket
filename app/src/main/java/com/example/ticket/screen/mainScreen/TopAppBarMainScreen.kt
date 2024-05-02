package com.example.ticket.screen.mainScreen

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
fun TopAppBarMainScreen(
    modifier: Modifier = Modifier,
    navigationAction:() -> Unit,
    action:() -> Unit,
    text: String
){

    TopAppBar(
        modifier = modifier,
        backgroundColor = topBarColor(),
        title = { TextTitle(text = text, color = StaticWithColor ) },
        navigationIcon = {
            IconButton(onClick = { navigationAction() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_settings_24),
                    contentDescription = "",
                    tint = StaticWithColor
                )
            }
        },
        actions = {
            IconButton(onClick = { action() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_update_24),
                    contentDescription = "",
                    tint = StaticWithColor
                )
            }
        }
    )

}