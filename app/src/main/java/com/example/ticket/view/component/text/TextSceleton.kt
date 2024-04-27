package com.example.ticket.view.component.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.ticket.ui.theme.AppTypography
import com.example.ticket.ui.theme.Fonts.TextMedium
import com.example.ticket.ui.theme.Fonts.TextTitle

@Composable
fun TextTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = TextTitle,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun TextBody(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    textAlign: TextAlign? = null,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = AppTypography.body1,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2, // Важно
        textAlign = textAlign
    )
}

@Composable
fun TextDefault(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = TextMedium,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun TextSmall(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
) {
    @Composable
    fun TextTitle(
        text: String,
        modifier: Modifier = Modifier,
        color: Color,
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            style = TextTitle,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}