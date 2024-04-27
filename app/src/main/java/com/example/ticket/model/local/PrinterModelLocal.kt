package com.example.ticket.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ticket.model.local.PrinterModelLocal.Companion.TABLE_PRINTER

@Entity(tableName = TABLE_PRINTER)
data class PrinterModelLocal(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int, // Имя пользователя

    @ColumnInfo(name = "name")
    val name: String, // Наименование.

    @ColumnInfo(name = "location")
    val location: String, // Наименование.
){
    companion object{
        const val TABLE_PRINTER = "table_printer"
    }
}

