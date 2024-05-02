package com.example.ticket.api

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ticket.dao.PersonDao
import com.example.ticket.dao.UserDao
import com.example.ticket.model.local.PersonModelLocal
import com.example.ticket.model.local.UserModel
import javax.inject.Inject
import javax.inject.Provider


@Database(entities = [UserModel::class, PersonModelLocal::class], version = 2, exportSchema = false)

abstract class DatabaseApi : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun personDao(): PersonDao


    class Callback @Inject constructor(private val database : Provider<DatabaseApi>, ): RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {

            super.onCreate(db)

            val daoUser =  database.get().userDao()

            val daoPerson = database.get().personDao()

        }
    }
}