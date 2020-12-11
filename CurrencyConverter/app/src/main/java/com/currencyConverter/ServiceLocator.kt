package com.currencyConverter

import com.currencyConverter.network.RetrofitServices

object ServiceLocator {
    private  var repository:Repository?=null
    fun provideRepository():Repository{

      return repository?:Repository(RetrofitServices.create())
    }
}