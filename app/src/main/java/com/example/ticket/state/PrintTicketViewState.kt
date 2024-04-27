package com.example.ticket.state

sealed class PrintTicketViewState {

    object Idle: PrintTicketViewState()

    object Loading: PrintTicketViewState()

    data class Success(
        val message: String
    ): PrintTicketViewState()

    data class Error(
        val message: String,
        val code: Int
    ): PrintTicketViewState()
}