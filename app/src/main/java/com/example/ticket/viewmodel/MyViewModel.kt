package com.example.ticket.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.ticket.repository.DataBaseRepository
import com.example.ticket.repository.OperationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    val operationRepository: OperationRepository,
    val dataBaseRepository: DataBaseRepository,
    private val app: Application,
): AndroidViewModel(app) {

}