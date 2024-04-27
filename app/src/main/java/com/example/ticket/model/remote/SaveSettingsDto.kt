package com.example.ticket.model.remote

data class SaveSettingsDto(
    val imei: String,
    val areaId: Int,
    val printerId: Int,
    val performerId: Int,
)
