package com.example.ticket.repository

import com.example.ticket.api.ApiService
import com.example.ticket.dto.LoginDto
import com.example.ticket.dto.PackUnpackDto
import com.example.ticket.dto.PrintTicketDto
import com.example.ticket.dto.ScannedTicketDto
import com.example.ticket.model.local.PersonModelLocal
import com.example.ticket.model.local.PlanTicketModelLocal
import com.example.ticket.model.local.UserModel
import com.example.ticket.model.remote.MessageModel
import com.example.ticket.model.remote.PackUnpackResult
import com.example.ticket.model.remote.ProductInfoModel
import com.example.ticket.model.remote.SaveSettingsDto
import com.example.ticket.model.remote.SettingsModel
import com.example.ticket.util.HttpResponseModel
import com.example.ticket.util.sendRequest
import javax.inject.Inject

class OperationRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun authorization(dto: LoginDto): HttpResponseModel<UserModel> =
        sendRequest { apiService.logIn(dto) }

    suspend fun getPlanOfArea(areaId: Int): HttpResponseModel<List<PlanTicketModelLocal>> =
        sendRequest { apiService.getPlanOfArea(areaId) }

    suspend fun  printTicket(dto: PrintTicketDto): HttpResponseModel<String> =
        sendRequest { apiService.printTicket(dto) }

    suspend fun getSettings(): HttpResponseModel<SettingsModel> =
        sendRequest { apiService.getSettings() }

    suspend fun saveSettings(dto: SaveSettingsDto): HttpResponseModel<MessageModel> =
        sendRequest { apiService.saveSettings(dto) }

    suspend fun getProductInfoFromScannerTicket(dto: ScannedTicketDto): HttpResponseModel<ProductInfoModel> =
        sendRequest { apiService.getProductInfoFromScannedTicket(dto) }

    suspend fun packUnpackProduct(dto: PackUnpackDto): HttpResponseModel<PackUnpackResult> =
        sendRequest { apiService.packUnpackProduct(dto) }

    suspend fun getPerson(): HttpResponseModel<List<PersonModelLocal>> =
        sendRequest { apiService.getPerson() }
}