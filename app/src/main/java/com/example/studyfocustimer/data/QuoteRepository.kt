package com.example.studyfocustimer.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteRepository {

    private val apiService: QuoteApiService = Retrofit.Builder()
        .baseUrl("https://zenquotes.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(QuoteApiService::class.java)

    suspend fun getRandomQuote(): Quote {
        return apiService.getRandomQuote().first()
    }
}