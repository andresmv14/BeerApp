package com.mv.core.core.repository

import com.mv.core.core.data.database.entities.BeerApp
import com.mv.core.core.data.database.entities.UserWithBeer
import com.mv.core.core.data.model.BeerProvider

object LocalConnection {

    private val connectionDb = BeerApp.db.getBeerDao()

    suspend fun getAllFavorites(): List<UserWithBeer> =
        this.connectionDb.getUserWithBeers(BeerProvider.id)
}