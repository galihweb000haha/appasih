package com.example.myuas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BooksClient {
    const val BASE_URL ="http://localhost/data_webservices/"


    // Buat instance
    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)

    }
}