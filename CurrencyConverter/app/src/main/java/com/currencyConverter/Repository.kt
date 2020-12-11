package com.currencyConverter

import com.currencyConverter.data_layer.CurrencyResponse
import com.currencyConverter.data_layer.ResultResponse
import com.currencyConverter.network.RetrofitServices

class Repository constructor(val retrofitServices: RetrofitServices){
    var API_KEY: String = BuildConfig.API_KEY


    suspend fun getCurrency():CurrencyResponse{
        return retrofitServices.getCurrency(API_KEY)
    }
    suspend fun getResult(from:String,to:String,amount:String):ResultResponse{
        return retrofitServices.getResult(API_KEY,from, to, amount)
    }
}