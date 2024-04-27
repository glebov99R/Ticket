package com.example.ticket.view.component.Spacer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SmallSpacer(){
    Spacer(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
}