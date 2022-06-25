package com.mv.beerapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://punkapi.com/documentation/v2").addConverterFactory(GsonConverterFactory.create()).build()
    }
}