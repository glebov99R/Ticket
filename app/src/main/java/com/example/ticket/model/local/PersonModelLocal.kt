package com.example.ticket.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ticket.model.local.PersonModelLocal.Companion.TABLE_PERSONS

@Entity(tableName = TABLE_PERSONS)
class PersonModelLocal(
    @PrimaryKey
    @ColumnInfo(name = "performerId")
    val performerId: Int, // id пользователя
    @ColumnInfo(name = "extSector")
    val extSector: Int, // Участок упаковки
    @ColumnInfo(name = "PfBarcode")
    val pfBarcode: String, // Номер пропуска
    @ColumnInfo(name = "performerName")
    val performerName: String, // Имя пользователя
) {
    companion object {
        const val TABLE_PERSONS = "table_persons"
    }
}