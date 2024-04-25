package com.example.ticket.util

import android.content.Context
import android.util.Log
import com.rscja.deviceapi.RFIDWithUHFRLM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RfidScanner {

    val rfidTags: MutableList<String> = mutableListOf()  // Список для хранения полученных меток

    private var rfidScanner: RFIDWithUHFRLM = RFIDWithUHFRLM.getInstance()  // Экземпляр RFID сканера
    private var isRfidScanning: Boolean = false  // Флаг, указывающий, выполняется ли в данный момент сканирование RFID

    companion object {
        @Volatile
        private var instance: RfidScanner? = null
        fun getInstance() = instance ?: synchronized(this) {  // Получение экземпляра класса RfidScanner
            instance ?: RfidScanner().also { instance = it }  // Если экземпляр уже существует, возвращается, иначе создается новый экземпляр
        }
    }

    suspend fun initialize(callback: suspend () -> Unit, errorHandler: (String) -> Unit) {
        withContext(Dispatchers.IO) {
            try {
                rfidScanner.init()  // Инициализация RFID сканера
                rfidScanner.power = 30 // Установка мощности сканера
                callback()  // Вызов обратного вызова, указанного в параметре callback
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    errorHandler(ex.toString())  // Обработка ошибки и вызов обработчика ошибок, указанного в параметре errorHandler
                }
            }
        }
        // ProgressDialog.dismiss()
    }

    suspend fun reinitialize(callback: suspend () -> Unit, context: Context, errorHandler: (String) -> Unit) {
        withContext(Dispatchers.IO) {
            rfidScanner.free()  // Освобождение ресурсов RFID сканера
            try {
                rfidScanner.init()  // Инициализация RFID сканера
                rfidScanner.power = 30 // Установка мощности сканера
                callback()
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    errorHandler(e.toString())  // Обработка ошибки и вызов обработчика ошибок, указанного в параметре errorHandler
                }
            }
        }
    }

    suspend fun startScan(errorHandler: () -> Unit) {
        Log.d("rfidList","Внутри функции${rfidTags}")
//        rfidTags.clear()  // Очистка списка меток
        if (!isRfidScanning) when (rfidScanner.startInventoryTag()) {  // Если сканирование успешно запущено
            true -> {
                isRfidScanning = true  // Установка флага сканирования в true
                withContext(Dispatchers.IO) {
                    while (isRfidScanning) rfidScanner.readTagFromBuffer().also {  // Чтение меток из буфера
                        if (it != null && !rfidTags.contains(it.epc)) rfidTags.add(it.epc)  // Добавление новых меток в список
                    }
                }
            }
            false -> errorHandler()  // Вызов обработчика ошибок при неудачном запуске сканирования
        }
    }

    suspend fun stopScan(errorHandler: () -> Unit) {
        if (isRfidScanning) {  // Если выполняется сканирование
            isRfidScanning = false  // Установка флага сканирования в false
            withContext(Dispatchers.IO) {
                if (!rfidScanner.stopInventory()) errorHandler()  // Остановка сканирования и вызов обработчика ошибок при неудаче
            }
        }
    }

    suspend fun free() {
        withContext(Dispatchers.IO) {
            rfidScanner.free()
            rfidScanner.stopInventory()
        }
    }


    suspend fun isPower(callback:  (Boolean) -> Unit){
        callback(rfidScanner.isPowerOn)
    }

}