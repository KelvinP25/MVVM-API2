package com.example.mvvm.domain

import com.example.mvvm.data.model.QuoteRepository
import com.example.mvvm.data.model.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()
}