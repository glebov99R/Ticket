package com.example.ticket.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.ConnectException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlin.concurrent.thread

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return try {
            Retrofit.Builder()
                .baseUrl("http://192.168.2.221:8888/eticket/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().apply {
                    callTimeout(2, TimeUnit.MINUTES)
                    connectTimeout(60, TimeUnit.SECONDS)
                    readTimeout(60, TimeUnit.SECONDS)
                    writeTimeout(60, TimeUnit.SECONDS)
                    // Перехватываем возможные исключения при подключении
                    addInterceptor { chain ->
                        try {
                            // Пропускаем запрос дальше
                            chain.proceed(chain.request())
                        } catch (e: IOException) {
                            // Если произошла ошибка, выводим лог и бросаем исключение дальше
                            e.printStackTrace()
                            throw IOException("Failed to connect to the server", e)
                        }
                    }
                }.build())
                .build()
                .create(ApiService::class.java)
        } catch (e: Exception) {
            // Обработка исключения при создании ApiService
            e.printStackTrace()
            // Можно бросить исключение дальше или вернуть дефолтное значение, например null
            throw RuntimeException("Failed to create ApiService", e)
        }
    }
}