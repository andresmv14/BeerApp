package com.mv.beerapp.data

import android.util.Log
import com.mv.beerapp.data.model.BeerModel
import com.mv.beerapp.data.model.BeerProvider
import com.mv.beerapp.data.network.BeerService

class BeerRepository {
    private val api = BeerService()
    suspend fun getAllBeers():List<BeerModel>{
        val response = api.getBeers()
        BeerProvider.beers = response
        Log.e("Aqui",response.toString())
        return response
    }
}