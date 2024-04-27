package com.example.ticket.state

import com.example.ticket.model.local.PersonModelLocal

sealed class GetPersonViewState {

    object Idle: GetPersonViewState()

    object Loading: GetPersonViewState()

    data class Success(
        val items: List<PersonModelLocal>
    ): GetPersonViewState()

    data class Error(
        val message: String,
        val code: Int
    ): GetPersonViewState()
}