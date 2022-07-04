package com.mv.beerapp.data


import com.mv.beerapp.data.database.entities.BeerApp
import com.mv.beerapp.data.database.entities.BeerEntity
import com.mv.beerapp.data.model.BeerModel
import com.mv.beerapp.data.model.BeerProvider
import com.mv.beerapp.data.network.BeerService
import com.mv.beerapp.modelo.BeerItem
import com.mv.beerapp.modelo.toDomain

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