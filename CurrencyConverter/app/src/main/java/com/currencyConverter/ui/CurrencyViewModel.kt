package com.currencyConverter.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.currencyConverter.Repository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CurrencyViewModel constructor(val repository: Repository) : ViewModel() {

    var amount: String = ""
    var givenCurrency: String = ""
    var requiredCurrency: String = ""
    var result: String = ""

    val currencyList = arrayOf("AED", "AFN", "ALL", "EGP", "AMD", "EURO")

    // for get the response error message
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    //for loading
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    fun getTheResult() {
        _loading.value = true
        viewModelScope.launch {

            val resultResponse =
                repository.getResult(givenCurrency, requiredCurrency, amount)
            if (resultResponse.success) {
                result = resultResponse.result
            } else {
                _error.value = resultResponse.error.info
            }
            _loading.value = false
        }
    }


}