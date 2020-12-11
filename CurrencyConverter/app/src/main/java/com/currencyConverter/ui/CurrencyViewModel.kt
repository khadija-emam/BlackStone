package com.currencyConverter.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.currencyConverter.Repository
import kotlinx.coroutines.launch

class CurrencyViewModel  constructor(val repository: Repository):ViewModel() {

    var  amount:String=""
    var givenCurrency:String=""
    var requiredCurrency:String=""
    var  result:String=""

    val currencyList= arrayOf("AED","AFN","ALL","EGP","AMD","EURO")



    fun getTheResult(){
        viewModelScope.launch {
          val resultResponse=repository.getResult(givenCurrency,requiredCurrency,amount)
            Log.i("TAG", "getTheResult: $amount")
            if (resultResponse.success){
                result=resultResponse.result
            }
        }
    }

}