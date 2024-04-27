package com.example.ticket.state

sealed class GetSettingsViewState{

    object Idle: GetSettingsViewState()

    object Loading: GetSettingsViewState()

    object Success: GetSettingsViewState()

    data class Error(
        val message: String,
        val code: Int
    ): GetSettingsViewState()
}

