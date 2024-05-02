package com.example.ticket.repository

import androidx.lifecycle.LiveData
import com.example.ticket.dao.PersonDao
import com.example.ticket.dao.UserDao
import com.example.ticket.model.local.PersonModelLocal
import javax.inject.Inject

class DataBaseRepository @Inject constructor(
    private val userDao: UserDao,
    private val personDao: PersonDao
) {
    /**
     * Добавления списка сотрудников в локульную БД
     */
    suspend fun cachePersonList(personList: List<PersonModelLocal>){
        personDao.also { it.addPersonToLocalDB(personList) }
    }

    /**
     * Получить сотрудник по его номеру пропуска
     */
    fun getPersonFromBarcode(barcode: String): LiveData<PersonModelLocal> {
        return personDao.getPersonFromBarcode(barcode)
    }

    /**
     * Получить полный список сотрудников
     */
    val getPersonList: LiveData<List<PersonModelLocal>> =
        personDao.getPerson()
}