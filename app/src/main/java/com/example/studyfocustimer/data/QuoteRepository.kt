package com.example.studyfocustimer.data

class QuoteRepository(
    private val apiService: QuoteApiService
) {
    suspend fun getRandomQuote(): Quote {
        return apiService.getRandomQuote().first()
    }
}