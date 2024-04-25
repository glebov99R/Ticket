package com.example.ticket.api

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ticket.dao.UserDao
import com.example.ticket.model.local.UserModel
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [UserModel::class], version = 1, exportSchema = false)

abstract class DatabaseApi : RoomDatabase() {

    abstract fun userDao(): UserDao


    class Callback @Inject constructor(private val database : Provider<DatabaseApi>, ): RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {

            super.onCreate(db)

            val daoUser =  database.get().userDao()

        }
    }
}