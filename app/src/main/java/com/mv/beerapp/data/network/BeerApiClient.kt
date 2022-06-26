package com.mv.beerapp.data.network

import com.mv.beerapp.data.model.BeerModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface BeerApiClient {
    @GET("beers")
    suspend fun getAllBeers():Response<List<BeerModel>>
}