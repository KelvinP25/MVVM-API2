package com.example.mvvm.domain

import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.data.model.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){

    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumer = (quotes.indices).random()
            return quotes[randomNumer]
        }
        return null
    }
}