package com.example.mvvm.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.model.database.dao.QuoteDao
import com.example.mvvm.data.model.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao():QuoteDao
}