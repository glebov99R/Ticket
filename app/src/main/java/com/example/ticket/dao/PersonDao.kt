package com.example.ticket.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ticket.model.local.PersonModelLocal

@Dao
interface PersonDao {

    @Insert(entity = PersonModelLocal::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPersonToLocalDB(personLocalModel: List<PersonModelLocal>)

    @Query(value = "SELECT * FROM ${PersonModelLocal.TABLE_PERSONS}")
    fun getPerson(): LiveData<List<PersonModelLocal>>

    @Query("SELECT * FROM ${PersonModelLocal.TABLE_PERSONS} WHERE PfBarcode = :barcode")
    fun getPersonFromBarcode(barcode: String): LiveData<PersonModelLocal>

}