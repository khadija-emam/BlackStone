package com.currencyConverter.data_layer

import com.google.gson.annotations.SerializedName


data class CurrencyResponse (
    @SerializedName("sucess")val success:Boolean,
    @SerializedName("symbols")val symbols:List<String>
)
data class ResultResponse (
    @SerializedName("sucess")val success:Boolean,
    @SerializedName("result")val result:String,
    @SerializedName("error")val error:Error
    )
data class Error(
    @SerializedName("info")val info:String
)