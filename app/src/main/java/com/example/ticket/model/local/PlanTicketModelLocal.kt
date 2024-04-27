package com.example.ticket.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ticket.model.local.PlanTicketModelLocal.Companion.TABLE_PLAN_TICKET

@Entity(tableName = TABLE_PLAN_TICKET)
data class PlanTicketModelLocal(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int, // id Плана
    @ColumnInfo(name = "shift")
    val shift: Int, // Смена
    @ColumnInfo(name = "productId")
    val productId: Int, // ИД Продукции
    @ColumnInfo(name = "areaId")
    val areaId: Int, // ID участка печи
    @ColumnInfo(name = "count")
    val count: Int, // 0 по дефолту
    @ColumnInfo(name = "date")
    val date: String, // Двтв плана
    @ColumnInfo(name = "productName")
    val productName: String, // Наименование продукции
    @ColumnInfo(name = "shortProductName")
    val shortProductName: String, // Короткое наименование
    @ColumnInfo(name = "productType")
    val productType: String, // Например декларированная(не нужна)
    @ColumnInfo(name = "productVendorCode")
    val productVendorCode: String,
    @ColumnInfo(name = "productColor")
    val productColor: String,
    @ColumnInfo(name = "productBarcode")
    val productBarcode: String,
    @ColumnInfo(name = "productCountInPackage")
    val productCountInPackage: Int,
    @ColumnInfo(name = "rowsInPackage")
    val rowsInPackage: Int,
    @ColumnInfo(name = "packageWeight")
    val packageWeight: Int,
    @ColumnInfo(name = "packageHWD")
    val packageHWD: String,
    @ColumnInfo(name = "areaName")
    val areaName: String // Имя сектора  (линия 1 итд)
) {
    companion object {
        const val  TABLE_PLAN_TICKET = "table_plan_ticket"
    }
}
