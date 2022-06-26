package com.mv.beerapp.domain

import com.mv.beerapp.data.BeerRepository
import com.mv.beerapp.data.model.BeerModel

class getBeers {
    private val repository = BeerRepository()

    suspend operator fun invoke():List<BeerModel> = repository.getAllBeers()
}