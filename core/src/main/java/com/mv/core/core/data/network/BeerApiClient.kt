package com.mv.core.core.data.network

import com.mv.core.core.data.model.BeerModel
import retrofit2.Response
import retrofit2.http.GET

interface BeerApiClient {
    @GET("beers")
    suspend fun getAllBeers():Response<List<BeerModel>>
}