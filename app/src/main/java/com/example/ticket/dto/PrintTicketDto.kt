package com.example.ticket.dto

data class PrintTicketDto(
    val performerId: Int,
    val areaId: Int,
    val barcode: String,
    val printerName: String,
)
