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
import com.example.ticket.ui.theme.backgroundCardColor
import com.example.ticket.ui.theme.borderStrokeButton
import com.example.ticket.view.component.text.TextBody

@Composable
fun DismissButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = backgroundCardColor(),
        contentColor = backgroundCardColor(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, borderStrokeButton()),
        modifier = modifier
            .clickable(onClick = onClick)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextBody(
                text = text,
                color = borderStrokeButton(),
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}