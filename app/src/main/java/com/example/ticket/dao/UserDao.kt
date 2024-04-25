package com.example.ticket.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ticket.model.local.UserModel

@Dao
interface UserDao {
    @Query("select * from UserModel limit 1")
    fun getFirst(): UserModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserModel)

    @Delete
    fun delete(user: UserModel)
}