package com.example.ticket.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PersonModelLocal(
    @PrimaryKey(autoGenerate = false) val performerId: Int, // id пользователя
    @ColumnInfo(name = "extSector") val extSector: Int,
    @ColumnInfo(name = "PfBarcode") val pfBarcode: String,
    @ColumnInfo(name = "performerName") val performerName: String, // Имя пользователя
)