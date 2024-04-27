package com.example.ticket.state

sealed class LoginViewState{

    object Idle: LoginViewState()

    object Loading: LoginViewState()

    object Success: LoginViewState()

    data class Error(
        val message: String,
        val code: Int
    ): LoginViewState()
}
