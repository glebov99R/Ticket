package com.example.ticket.model.remote

import com.example.ticket.model.local.AreaModelLocal
import com.example.ticket.model.local.PrinterModelLocal

data class SettingsModel(
    val printers: List<PrinterModelLocal>,
    val areas: List<AreaModelLocal>,
)

