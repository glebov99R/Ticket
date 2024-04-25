package com.example.ticket.view.component.circularProgress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun CircularProgress(
    modifier: Modifier = Modifier,
    color: Color,
    size: Dp,
    height: Float,
    strokeWidth: Dp,
    Arrangement: Arrangement.Vertical,
    Alignment: Alignment.Horizontal

) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(height),
        verticalArrangement = Arrangement,
        horizontalAlignment = Alignment
    ) {
        CircularProgressIndicator(
            color = color,
            strokeWidth = strokeWidth,
            modifier = modifier.size(size)
        )
    }
}