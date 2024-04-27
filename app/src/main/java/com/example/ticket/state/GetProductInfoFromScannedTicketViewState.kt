package com.example.ticket.state

import com.example.ticket.model.remote.ProductInfoModel

sealed class GetProductInfoFromScannedTicketViewState {

    object Idle: GetProductInfoFromScannedTicketViewState()

    object Loading: GetProductInfoFromScannedTicketViewState()

    data class Success(
        val item: ProductInfoModel
    ): GetProductInfoFromScannedTicketViewState()

    data class Error(
        val message: String,
        val code: Int
    ): GetProductInfoFromScannedTicketViewState()
}