package com.example.ticket.util

import retrofit2.Response

/**
 * Принимает в качестве параметра функцию apiFun, которая является функцией-запросом к API и возвращает Response<R>. Здесь R - это тип ожидаемого ответа.
 * Вызывает функцию apiFun, используя ключевое слово suspend для указания асинхронного выполнения запроса. Это означает, что выполнение функции будет приостановлено, пока не будет получен ответ от API.
 * Получает результат выполнения функции apiFun и сохраняет его в переменной this.
 * Использует выражение run для выполнения блока кода над полученным результатом this. В данном случае, блок кода содержит выражение when, которое проверяет значение isSuccessful в объекте this.
 * Если isSuccessful равно true, то возвращает HttpResponseModel.Success(body()), где body() - это тело ответа API, которое будет передано как параметр конструктору HttpResponseModel.Success.
 * Если isSuccessful равно false, то возвращает HttpResponseModel.Error(code(), message()), где code() и message() - это методы объекта this, возвращающие код ошибки и сообщение об ошибке соответственно.
 * Таким образом, функция sendRequest выполняет запрос к API, обрабатывает результат и возвращает объект HttpResponseModel, который представляет собой обертку для успешного ответа или ошибки.
 */
suspend fun <R : Any> sendRequest(apiFun: suspend () -> Response<R>): HttpResponseModel<R> =
    apiFun().run {
        return@run when (isSuccessful) {
            true -> HttpResponseModel.Success(body())
            false -> HttpResponseModel.Error(code(), message())
        }
    }