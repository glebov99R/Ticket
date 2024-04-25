package com.example.ticket.view.component.CustomCard

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ticket.ui.theme.AppShapes
import com.example.ticket.ui.theme.staticCardColor


@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    shape: Shape = AppShapes.medium,
    backgroundColor: Color = staticCardColor,
    contentColor: Color = staticCardColor,
    border: BorderStroke? = null,
    elevation: Dp = 5.dp,
    content: @Composable () -> Unit
){
    Card(
        modifier = modifier,
        shape = shape,
        border = border,
        elevation = elevation,
        contentColor = contentColor,
        content = content,
        backgroundColor = backgroundColor
    )
}