package com.mv.beerapp.data.network

import com.mv.beerapp.core.RetrofitHelper
import com.mv.beerapp.data.model.BeerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class BeerService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBeers():List<BeerModel>{
        return withContext(Dispatchers.IO){
            val response= retrofit.create(BeerApiClient::class.java).getAllBeers()
            response.body()?: emptyList()
        }

    }
}