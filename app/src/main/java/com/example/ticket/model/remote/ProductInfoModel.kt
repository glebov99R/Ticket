package com.example.ticket.model.remote

data class ProductInfoModel(
    val hasError: Boolean,
    val operationName: String,
    val areaName: String,
    val performerName: String,
    val barcode: String,
    val tag: String,
    val date: String,
    val shortName: String,
    val vendorCode: String,
    val color: String,
    val rowsInPackage: Int,
    val packageHWD: String,
    val bottlesCount: Int,
)
