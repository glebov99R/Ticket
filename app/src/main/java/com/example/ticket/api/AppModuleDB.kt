package com.example.ticket.api

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleDB {

    @Provides
    @Singleton
    fun provideRoomDB(
        app: Application,
        callback: DatabaseApi.Callback
    ) = Room.databaseBuilder(app, DatabaseApi::class.java, "fgw_rfid")
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        .addCallback(callback)
        .build()

    @Provides
    fun provideUserDao(db: DatabaseApi) = db.userDao()
}