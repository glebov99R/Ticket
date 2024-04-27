package com.example.ticket.view.component.AlertDialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.ticket.view.component.Button.ConfirmButton
import com.example.ticket.view.component.Button.DismissButton
import com.example.ticket.view.component.Spacer.SmallSpacer
import com.example.ticket.view.component.text.TextBody

@Composable
fun QuestionAlertDialog(
    onDismiss:() -> Unit,
    onConfirm:() -> Unit,
    dismissText: String,
    confirmText: String,
    textQuestion: String
) {

    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            elevation = 8.dp
        ) {
            Column(
                Modifier.background(backgroundCardColor()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                SmallSpacer()

                TextBody(
                    text = textQuestion,
                    modifier = Modifier.padding(5.dp),
                    color = StaticColorTextInAlertDialog
                )

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.Center
                ) {

                    DismissButton(
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1F),
                        onClick = { onDismiss() },
                        text = dismissText
                    )

                    ConfirmButton(
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1F),
                        onClick = { onConfirm() },
                        text = confirmText
                    )
                }
            }
        }
    }
}