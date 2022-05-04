package com.example.mvvm.domain

import com.example.mvvm.data.model.QuoteRepository
import com.example.mvvm.data.model.database.entities.toDatabase
import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {


    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.ClearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getALlQuotesFromDatabse()
        }
    }
}