package com.example.ticket.state

sealed class SaveSettingsViewState {

    object Idle: SaveSettingsViewState()

    object Loading: SaveSettingsViewState()

    object Success: SaveSettingsViewState()

    data class Error(
        val message: String,
        val code: Int
    ): SaveSettingsViewState()
}
