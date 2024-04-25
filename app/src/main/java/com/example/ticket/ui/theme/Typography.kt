package com.example.ticket.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ticket.R

private val FontTTF = FontFamily(
    Font(R.font.dmsans_regular, FontWeight.Normal),
    Font(R.font.dmsans_medium, FontWeight.Medium),
    Font(R.font.dmsans_bold, FontWeight.Bold),

    //Italics - курсив(наклоннй шрифт)
    Font(R.font.dmsans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.dmsans_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.dmsans_bold_italic, FontWeight.Bold, FontStyle.Italic),
)

internal object Fonts {
    val TextTitle = TextStyle(
        fontFamily = FontTTF,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )

    val TextBody = TextStyle(
        fontFamily = FontTTF,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    )

    val TextMedium = TextStyle(
        fontFamily = FontTTF,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    )

    val TextSmall = TextStyle(
        fontFamily = FontTTF,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    )
}

var AppTypography = Typography(
    h1 = Fonts.TextTitle,
    h2 = Fonts.TextTitle,
    h3 = Fonts.TextTitle,
    h4 = Fonts.TextTitle,
    h5 = Fonts.TextTitle,
    h6 = Fonts.TextTitle,
    subtitle1 = Fonts.TextTitle,
    subtitle2 = Fonts.TextTitle,
    body1 = Fonts.TextBody,
    body2 = Fonts.TextBody,
    button = Fonts.TextBody,
    caption = Fonts.TextMedium,
    overline = Fonts.TextSmall
)