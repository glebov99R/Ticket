package com.example.ticket.api

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
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("aVEjY6Wa2qMxLKfo1ZwOxYpET1qnLS1Bp1YXEmQa")
    suspend fun logIn(@Body dto: LoginDto): Response<UserModel>

    @POST("aVEjY6Wa2qMxLKfo1ZwOxYpET1qnLS1Bp1YXEmQf")
    suspend fun getPerson(): Response<List<PersonModelLocal>>

    @GET("nv9zJlBc3cATRRodzLR3AVaMZ2UzsGDiA5anDS29")
    suspend fun getSettings(): Response<SettingsModel>

    @POST("nv9zJlBc3cATRRodzLR3AVaMZ2UzsGDiA5anDS29")
    suspend fun saveSettings(@Body dto: SaveSettingsDto): Response<MessageModel>

    @GET("0lxIbhT5AaUf5yhYLLyqXugZ9bfh3aFtmt3PMYtk")
    suspend fun getPlanOfArea(@Query("id") areaId: Int): Response<List<PlanTicketModelLocal>>

    @POST("jIZKJQcZx6DLT7JC4YqKmPwhDJ1A8tckHDdvgVWf")
    suspend fun printTicket(@Body dto: PrintTicketDto): Response<String>

    @POST("pGh7vgS2Ewsrawiw9ANsXs5tPWFcwh02BWJOaVi5")
    suspend fun getProductInfoFromScannedTicket(@Body dto: ScannedTicketDto): Response<ProductInfoModel>

    @POST("yrd2TTpd560qUobYpBqZGlnPlw3nfgNW7yUbL1jo")
    suspend fun packUnpackProduct(@Body dto: PackUnpackDto): Response<PackUnpackResult>

}