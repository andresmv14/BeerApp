package com.mv.beers.domain

import com.mv.core.core.data.BeerRepository
import com.mv.core.core.data.database.entities.toDatbase
import com.mv.core.core.data.modelo.BeerItem

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