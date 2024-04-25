package com.example.ticket.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    @PrimaryKey(autoGenerate = false) val performerId: Int, // id пользователя
    @ColumnInfo(name = "performerName") val performerName: String, // Имя пользователя
)
