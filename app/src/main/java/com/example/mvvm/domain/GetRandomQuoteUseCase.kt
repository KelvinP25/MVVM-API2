package com.example.mvvm.domain

import com.example.mvvm.data.model.QuoteRepository
import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke():Quote?{
        val quotes = repository.getALlQuotesFromDatabse()
        if(!quotes.isNullOrEmpty()){
            val randomNumer = (quotes.indices).random()
            return quotes[randomNumer]
        }
        return null
    }
}