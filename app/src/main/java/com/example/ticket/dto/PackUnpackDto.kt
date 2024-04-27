package com.example.ticket.dto

data class PackUnpackDto(
    val imei: String,
    val areaId: Int,
    val performerId: Int,
    val operationType: Int, // 2 - pack, 3 - unpack
    val vendorCode: String,
    val barcode: String,
    val rfid: String,
)
