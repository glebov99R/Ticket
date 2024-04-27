package com.example.ticket.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ticket.model.local.AreaModelLocal.Companion.TABLE_AREA

@Entity(tableName = TABLE_AREA)
data class AreaModelLocal(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int, // Имя пользователя

    @ColumnInfo(name = "name")
    val name: String, // Наименование.

) {
    companion object{
        const val TABLE_AREA = "table_area"
    }
}
