package com.example.ticket.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.barcode.BarcodeUtility

class BarcodeBroadcastReceiver(private val onBarcodeScanned: (barcodeValue: String) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == BarcodeUtility.SCANNER_BROADCAST_ACTION) {
            val barcodeValue =
                intent.getStringExtra("BARCODE") // Получает значение отсканированного штрих-кода
            onBarcodeScanned(
                barcodeValue ?: ""
            ) // Вызывает функцию обратного вызова, передавая значение отсканиров
        }
    }
}