package com.example.mvvm.domain.model

import com.example.mvvm.data.model.database.entities.QuoteEntity
import com.example.mvvm.data.model.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)