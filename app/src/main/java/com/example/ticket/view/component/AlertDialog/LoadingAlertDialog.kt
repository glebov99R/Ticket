package com.example.ticket.view.component.AlertDialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.ticket.ui.theme.StaticColorTextInAlertDialog
import com.example.ticket.ui.theme.backgroundCardColor
import com.example.ticket.ui.theme.barsColor
import com.example.ticket.view.component.circularProgress.CircularProgress
import com.example.ticket.view.component.text.TextBody

@Composable
fun LoadingAlertDialog(
    onDismiss:() -> Unit,
    textQuestion: String,
    show: Boolean
){
    if(show){
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Card(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .height(80.dp)
                    .width(300.dp)
                    .padding(8.dp),
                elevation = 8.dp
            ) {
                Column(
                    Modifier
                        .background(backgroundCardColor())
                        .wrapContentSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 10.dp, end = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextBody(
                            text = textQuestion,
                            color = StaticColorTextInAlertDialog
                        )

                        CircularProgress(
                            color = barsColor(),
                            size = 30.dp,
                            height = 0.85f,
                            strokeWidth = 4.dp,
                            Arrangement = Arrangement.Center,
                            Alignment = Alignment.CenterHorizontally)
                    }
                }
            }
        }
    }
}