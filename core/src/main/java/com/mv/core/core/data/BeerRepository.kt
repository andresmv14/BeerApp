package com.mv.core.core.data


import com.mv.core.core.data.database.entities.BeerApp
import com.mv.core.core.data.database.entities.BeerEntity
import com.mv.core.core.data.model.BeerModel
import com.mv.core.core.data.model.BeerProvider
import com.mv.core.core.data.network.BeerService
import com.mv.core.core.data.modelo.BeerItem
import com.mv.core.core.data.modelo.toDomain

class BeerRepository {
    private val api = BeerService()
    private val beerDao = BeerApp.db.getBeerDao()
    suspend fun getAllBeers():List<BeerItem>{
        val response: List<BeerModel> = api.getBeers()
        BeerProvider.beers = response
        return response.map{it.toDomain()}
    }

    suspend fun getBeersFromDb():List<BeerItem>{
        val response: List<BeerEntity> = beerDao.getAllBeers()
        return response.map{it.toDomain()}
    }

    suspend fun insertBeers(beers:List<BeerEntity>){
            beerDao.inserBeers(beers)
    }

    suspend fun clearBeers(){
        beerDao.deleteAllBeers()
    }
}