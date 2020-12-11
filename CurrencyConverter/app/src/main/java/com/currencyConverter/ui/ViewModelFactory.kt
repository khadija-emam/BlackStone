package com.currencyConverter.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.currencyConverter.Repository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory (val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return CurrencyViewModel(repository) as T
    }

}
