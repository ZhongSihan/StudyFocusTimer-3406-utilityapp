package com.example.studyfocustimer

import com.example.studyfocustimer.data.QuoteApiService
import com.example.studyfocustimer.data.QuoteRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://zenquotes.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val quoteApiService: QuoteApiService =
        retrofit.create(QuoteApiService::class.java)

    val quoteRepository = QuoteRepository(quoteApiService)
}