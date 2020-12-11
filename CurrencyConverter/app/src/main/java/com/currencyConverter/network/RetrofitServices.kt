package com.currencyConverter.network

import com.currencyConverter.data_layer.CurrencyResponse
import com.currencyConverter.data_layer.ResultResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface RetrofitServices {
    @GET("symbols")
    suspend fun getCurrency(@Query("access_key") string: String): CurrencyResponse

    @GET("covert")
    suspend fun getResult(
        @Query("access_key") string: String
        , @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: String
    ): ResultResponse

    companion object {
        fun create(): RetrofitServices {
            val client = OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
            return Retrofit.Builder()
                .baseUrl("http://data.fixer.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(RetrofitServices::class.java)
        }
    }
}