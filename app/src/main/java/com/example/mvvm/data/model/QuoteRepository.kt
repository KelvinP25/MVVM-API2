package com.example.mvvm.data.model

import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.data.model.model.QuoteProvider
import com.example.mvvm.data.model.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteProvider: QuoteProvider){


    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
       quoteProvider.quotes = response
        return response
    }
}