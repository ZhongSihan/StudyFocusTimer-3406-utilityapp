package com.example.studyfocustimer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyfocustimer.data.QuoteRepository
import kotlinx.coroutines.launch

class FocusViewModel : ViewModel() {

    private val repository = QuoteRepository()

    var quoteText by mutableStateOf("Load a focus quote to get started.")
        private set

    var quoteAuthor by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf("")
        private set

    fun loadRandomQuote() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = ""

            try {
                val quote = repository.getRandomQuote()
                quoteText = quote.text
                quoteAuthor = quote.author
            } catch (exception: Exception) {
                errorMessage = "Unable to load quote."
            }

            isLoading = false
        }
    }
}