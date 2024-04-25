package com.example.ticket.repository

import com.example.ticket.api.ApiService
import javax.inject.Inject

class OperationRepository @Inject constructor(
    private val apiService: ApiService
) {

}