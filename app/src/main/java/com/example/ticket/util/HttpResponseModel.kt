package com.example.ticket.util

/**
 * Модель ответа HTTP.
 */
sealed class HttpResponseModel<out T> {
    /**
     * Успешно.
     * @param data Данные полученные от ответа HTTP.
     *
     * @return ответ от HTTP.
     */
    data class Success<T>(val data: T?) : HttpResponseModel<T>()

    /**
     * Ошибка.
     * @param code Код ошибки.
     * @param message Информация об ошибке.
     *
     * @return ответ от HTTP.
     */
    data class Error<T>(val code: Int, val message: String) : HttpResponseModel<T>() {
        constructor(t: Throwable) : this(0,t.message ?: "")
    }
}

