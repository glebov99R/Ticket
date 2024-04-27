package com.example.ticket.view.component.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ticket.ui.theme.StaticWithColor
import com.example.ticket.ui.theme.barsColor
import com.example.ticket.view.component.text.TextBody

@Composable
fun ConfirmButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
) {
    Surface(
        color = barsColor(),
        contentColor = barsColor(),
        shape = RoundedCornerShape(8.dp),
        border = border,
        modifier = modifier
            .clickable(onClick = onClick)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBody(
                text = text,
                color = StaticWithColor,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}