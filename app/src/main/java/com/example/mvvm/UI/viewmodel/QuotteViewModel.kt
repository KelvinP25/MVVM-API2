package com.example.mvvm.UI.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.data.model.model.QuoteProvider
import com.example.mvvm.domain.GetQuotesUseCase
import kotlinx.coroutines.launch


class QuotteViewModel : ViewModel(){
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
    fun randomQuote(){
        //val currentQuote = QuoteProvider.random()
        //quoteModel.postValue(currentQuote)
    }


}