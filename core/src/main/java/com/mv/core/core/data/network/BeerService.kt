package com.mv.core.core.data.network

import com.mv.core.core.RetrofitHelper
import com.mv.core.core.data.model.BeerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeerService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBeers():List<BeerModel>{
        return withContext(Dispatchers.IO){
            val response= retrofit.create(BeerApiClient::class.java).getAllBeers()
            response.body()?: emptyList()
        }

    }


}