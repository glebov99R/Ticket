package com.example.ticket.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.barcode.BarcodeUtility
import com.example.ticket.dto.LoginDto
import com.example.ticket.dto.PackUnpackDto
import com.example.ticket.dto.PrintTicketDto
import com.example.ticket.dto.ScannedTicketDto
import com.example.ticket.model.local.PersonModelLocal
import com.example.ticket.model.local.UserModel
import com.example.ticket.model.remote.SaveSettingsDto
import com.example.ticket.repository.DataBaseRepository
import com.example.ticket.repository.OperationRepository
import com.example.ticket.state.GetPersonViewState
import com.example.ticket.state.GetPlanOfAreaViewState
import com.example.ticket.state.GetProductInfoFromScannedTicketViewState
import com.example.ticket.state.GetSettingsViewState
import com.example.ticket.state.LoginViewState
import com.example.ticket.state.PackUnpackProductViewState
import com.example.ticket.state.PrintTicketViewState
import com.example.ticket.state.SaveSettingsViewState
import com.example.ticket.util.HttpResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.ConnectException
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    val operationRepository: OperationRepository,
    val dataBaseRepository: DataBaseRepository,
    private val app: Application,
): AndroidViewModel(app) {

    val  context = app
    private val barcodeUtility: BarcodeUtility = BarcodeUtility.getInstance()

    private val _currentUser = MutableLiveData<UserModel>()
    val currentUser: LiveData<UserModel>
        get() = _currentUser

    private val _currentPerson = MutableLiveData<PersonModelLocal>()
    val currentPerson: LiveData<PersonModelLocal>
        get() = _currentPerson

    val allPersonListFromLocalDb = dataBaseRepository.getPersonList

    private val _getPlanOfAreaViewState =
        MutableStateFlow<GetPlanOfAreaViewState>(GetPlanOfAreaViewState.Idle)
    private val _getProductInfoFromScannedTicketViewState =
        MutableStateFlow<GetProductInfoFromScannedTicketViewState>(GetProductInfoFromScannedTicketViewState.Idle)
    private val _getSettingsViewState =
        MutableStateFlow<GetSettingsViewState>(GetSettingsViewState.Idle)
    private val _loginViewState =
        MutableStateFlow<LoginViewState>(LoginViewState.Idle)
    private val _packUnpackProductViewState =
        MutableStateFlow<PackUnpackProductViewState>(PackUnpackProductViewState.Idle)
    private val _printTicketViewState =
        MutableStateFlow<PrintTicketViewState>(PrintTicketViewState.Idle)
    private val _saveSettingsViewState =
        MutableStateFlow<SaveSettingsViewState>(SaveSettingsViewState.Idle)
    private val _getPersonViewState =
        MutableStateFlow<GetPersonViewState>(GetPersonViewState.Idle)


    val getPlanOfAreaViewState = _getPlanOfAreaViewState.asStateFlow()
    val getProductInfoFromScannedTicketViewState = _getProductInfoFromScannedTicketViewState.asStateFlow()
    val getSettingsViewState = _getSettingsViewState.asStateFlow()
    val loginViewState = _loginViewState.asStateFlow()
    val packUnpackProductViewState = _packUnpackProductViewState.asStateFlow()
    val printTicketViewState = _printTicketViewState.asStateFlow()
    val saveSettingsViewState = _saveSettingsViewState.asStateFlow()
    val getPersonViewState = _getPersonViewState.asStateFlow()


    fun clearGetPlanOfAreaViewState(){
        _getPlanOfAreaViewState.value = GetPlanOfAreaViewState.Idle
    }
    fun clearGetProductInfoFromScannedTicketViewState(){
        _getProductInfoFromScannedTicketViewState.value = GetProductInfoFromScannedTicketViewState.Idle
    }
    fun clearGetSettingsViewState(){
        _getSettingsViewState.value = GetSettingsViewState.Idle
    }
    fun clearLoginViewState(){
        _loginViewState.value = LoginViewState.Idle
    }
    fun clearPackUnpackProductViewState(){
        _packUnpackProductViewState.value = PackUnpackProductViewState.Idle
    }
    fun clearPrintTicketViewState(){
        _printTicketViewState.value = PrintTicketViewState.Idle
    }
    fun clearSaveSettingsViewState(){
        _saveSettingsViewState.value = SaveSettingsViewState.Idle
    }
    fun clearGetPersonViewState(){
        _getPersonViewState.value = GetPersonViewState.Idle
    }

    fun restartBarcodeScanner(context: Context){
        barcodeUtility.setOutputMode(context, 2) //  Устанавливает режим вывода результатов сканирования
        barcodeUtility.setScanResultBroadcast(context, BarcodeUtility.SCANNER_BROADCAST_ACTION, "BARCODE") // Устанавливает трансляцию результата сканирования.
        barcodeUtility.open(context, BarcodeUtility.ModuleType.BARCODE_2D) // Открывает модуль сканера для использования.
        barcodeUtility.setReleaseScan(context, false) // Устанавливает режим освобождения сканирования.
        barcodeUtility.setScanFailureBroadcast(context, true) // Устанавливает трансляцию при неудачном сканировании.
        barcodeUtility.enableContinuousScan(context, false) // Включает или выключает непрерывное сканирование.
        barcodeUtility.enablePlaySuccessSound(context, false)
        barcodeUtility.enablePlayFailureSound(context, false)
        barcodeUtility.enableEnter(context, false) // Включает или выключает вставку символа Enter после сканирования.
        barcodeUtility.setBarcodeEncodingFormat(context, 1) // Устанавливает формат штрих-кода для сканирования.
    }

    fun authorization(barcode: String) {
        viewModelScope.launch {
            _loginViewState.value = LoginViewState.Loading
            try {
                // Попытка выполнения запроса на авторизацию
                val response = operationRepository.authorization(
                    dto = LoginDto(
                        barcode = barcode,
                        imei = ""
                    )
                )
                // Обработка ответа
                when (response) {
                    is HttpResponseModel.Success -> {
                        _loginViewState.value = LoginViewState.Success
                        _currentUser.value = response.data
                    }
                    is HttpResponseModel.Error -> {
                        _loginViewState.value = LoginViewState.Error(
                            message = response.message,
                            code = response.code
                        )
                    }
                }
            } catch (e: Exception) {
                // Обработка ошибки подключения
                _loginViewState.value = LoginViewState.Error(
                    message = "Ошибка подклюения к серверу",
                    code = 303
                )
            }
        }
    }

    fun getSettings(){
        viewModelScope.launch {
            _getSettingsViewState.value = GetSettingsViewState.Loading
            try {
                val response = operationRepository.getSettings()
                when(response){
                    is HttpResponseModel.Success -> {
                        _getSettingsViewState.value = GetSettingsViewState.Success
                    }
                    is HttpResponseModel.Error -> {
                        _getSettingsViewState.value = GetSettingsViewState.Error(
                            message = response.message,
                            code = response.code
                        )
                    }
                }
            } catch (e: Exception){
                _getSettingsViewState.value = GetSettingsViewState.Error(
                    message= "Ошибка подлкючения к серверу",
                    code = 303
                )
            }
        }
    }

    fun saveSettings(
        imei: String,
        areaId: Int,
        printerId: Int,
        performerId: Int
    ){
        viewModelScope.launch {
            _saveSettingsViewState.value = SaveSettingsViewState.Loading
            try {
                val response = operationRepository
                    .saveSettings(SaveSettingsDto(
                        imei = imei,
                        areaId = areaId,
                        printerId = printerId,
                        performerId = performerId
                    ))
                when(response){
                    is HttpResponseModel.Success -> {
                        _saveSettingsViewState.value = SaveSettingsViewState.Success
                    }
                    is HttpResponseModel.Error -> {
                        _saveSettingsViewState.value = SaveSettingsViewState.Error(
                            message = response.message,
                            code = response.code
                        )
                    }
                }
            } catch (e: Exception){
                _saveSettingsViewState.value = SaveSettingsViewState.Error(
                    message = "Ошибка подлкючения к серверу",
                    code = 303
                )
            }
        }
    }

    fun getPlanOfArea(areaId: Int){
        viewModelScope.launch {
            _getPlanOfAreaViewState.value = GetPlanOfAreaViewState.Loading
            try {
                val response =
                    operationRepository.getPlanOfArea(areaId)
                when(response){
                    is HttpResponseModel.Success -> {
                        _getPlanOfAreaViewState.value = GetPlanOfAreaViewState
                            .Success(item = response.data!!)
                    }
                    is HttpResponseModel.Error -> {
                        _getPlanOfAreaViewState.value = GetPlanOfAreaViewState.Error(
                            message = response.message,
                            code = response.code
                        )
                    }
                }
            } catch (e: Exception){
                _getPlanOfAreaViewState.value = GetPlanOfAreaViewState.Error(
                    message = "Ошибка подлкючения к серверу",
                    code = 303
                )
            }
        }
    }

    fun printTicket(
        performerId: Int,
        areaId: Int,
        barcode: String,
        printerName: String
    ){
        viewModelScope.launch {
            _printTicketViewState.value = PrintTicketViewState.Loading
            try {
                val response = operationRepository
                    .printTicket(
                        PrintTicketDto(
                            performerId = performerId,
                            areaId = areaId,
                            barcode = barcode,
                            printerName = printerName
                        )
                    )
                when(response){
                    is HttpResponseModel.Success -> {
                        _printTicketViewState.value = PrintTicketViewState.Success(response.data!!)
                    }
                    is HttpResponseModel.Error -> {
                        _printTicketViewState.value = PrintTicketViewState.Error(
                            message = response.message,
                            code = response.code
                        )
                    }
                }
            } catch (e: Exception){
                _printTicketViewState.value = PrintTicketViewState.Error(
                    message = "Ошибка подлкючения к серверу",
                    code = 303
                )
            }
        }
    }

    fun getProductInfoFromScannedTicket(
        barcode: String,
        tag: String
    ){
        viewModelScope.launch {
            _getProductInfoFromScannedTicketViewState.value =
                GetProductInfoFromScannedTicketViewState.Loading
            try {
                val response = operationRepository
                    .getProductInfoFromScannerTicket(
                        ScannedTicketDto(
                            barcode = barcode,
                            tag = tag
                        )
                    )
                when(response){
                    is HttpResponseModel.Success -> {
                        _getProductInfoFromScannedTicketViewState.value =
                            GetProductInfoFromScannedTicketViewState.Success(response.data!!)
                    }
                    is HttpResponseModel.Error -> {
                        _getProductInfoFromScannedTicketViewState.value =
                            GetProductInfoFromScannedTicketViewState.Error(
                                message = response.message,
                                code = response.code
                            )
                    }
                }
            } catch (e: Exception){
                _getProductInfoFromScannedTicketViewState.value =
                    GetProductInfoFromScannedTicketViewState.Error(
                    message = "Ошибка подлкючения к серверу",
                    code = 303
                )
            }
        }
    }

    fun packUnpackProduct(
        imei: String,
        areaId: Int,
        performerId: Int,
        operationType: Int,
        vendorCode: String,
        barcode: String,
        rfid: String
    ){
        viewModelScope.launch {
            _packUnpackProductViewState.value = PackUnpackProductViewState.Loading
            try {
                val response = operationRepository
                    .packUnpackProduct(
                        PackUnpackDto(
                            imei = imei,
                            areaId = areaId,
                            performerId = performerId,
                            operationType = operationType,
                            vendorCode = vendorCode,
                            barcode = barcode,
                            rfid = rfid
                        )
                    )
                when(response){
                    is HttpResponseModel.Success -> {
                        _packUnpackProductViewState.value =
                            PackUnpackProductViewState.Success(response.data!!)
                    }
                    is HttpResponseModel.Error -> {
                        _packUnpackProductViewState.value = PackUnpackProductViewState.Error(
                            message = response.message,
                            code = response.code
                        )
                    }
                }
            } catch (e: Exception){
                _packUnpackProductViewState.value = PackUnpackProductViewState.Error(
                    message = "Ошибка подлкючения к серверу",
                    code = 303
                )
            }
        }
    }

    fun getPeron(){
        viewModelScope.launch {
            _getPersonViewState.value = GetPersonViewState.Loading
            try {
                val response = operationRepository.getPerson()
                when(response){
                   is HttpResponseModel.Success -> {
                       dataBaseRepository.cachePersonList(response.data!!)
                       _getPersonViewState.value = GetPersonViewState.Success(response.data!!)
                   }
                    is HttpResponseModel.Error -> {
                        _getPersonViewState.value = GetPersonViewState.Error(
                            message = response.message,
                            code = response.code
                        )
                    }
                }
            } catch (e: Exception){
                _getPersonViewState.value = GetPersonViewState.Error(
                    message = "Ошибка подлкючения к серверу",
                    code = 303
                )
            }
        }
    }

    fun fetchPersonFromBarcode(barcode: String) {
        viewModelScope.launch {
            dataBaseRepository.getPersonFromBarcode(barcode).observeForever { person ->
                _currentPerson.postValue(person)
            }
        }
    }

}