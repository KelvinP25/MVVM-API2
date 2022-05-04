package com.example.mvvm.data.model

import com.example.mvvm.data.model.database.dao.QuoteDao
import com.example.mvvm.data.model.database.entities.QuoteEntity
import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.data.model.network.QuoteService
import com.example.mvvm.domain.model.Quote
import com.example.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {


    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getALlQuotesFromDatabse(): List<Quote> {
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun ClearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}