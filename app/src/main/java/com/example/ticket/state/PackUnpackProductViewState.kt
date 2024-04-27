package com.example.ticket.state

import com.example.ticket.model.remote.PackUnpackResult

sealed class PackUnpackProductViewState {

    object Idle: PackUnpackProductViewState()

    object Loading: PackUnpackProductViewState()

    data class Success(
        val item: PackUnpackResult
    ): PackUnpackProductViewState()

    data class Error(
        val message: String,
        val code: Int
    ): PackUnpackProductViewState()
}