package com.example.ticket.repository

import com.example.ticket.dao.UserDao
import javax.inject.Inject

class DataBaseRepository @Inject constructor(
    private val userDao: UserDao,
) {

}