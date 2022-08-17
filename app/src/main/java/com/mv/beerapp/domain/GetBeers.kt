package com.mv.beerapp.domain

import com.mv.beerapp.data.BeerRepository
import com.mv.beerapp.data.database.entities.toDatbase
import com.mv.beerapp.modelo.BeerItem

class GetBeers {
    private val repository = BeerRepository()

    suspend operator fun invoke():List<BeerItem> {
            val beers = repository.getAllBeers()
        return if(beers.isNotEmpty()){
            repository.clearBeers()
            repository.insertBeers(beers.map { it.toDatbase() })
            beers
        }else{
            repository.getBeersFromDb()
        }
    }
}