package com.mv.beers.domain.use_case

import com.mv.beers.domain.entity.FavoriteBeer
import com.mv.beers.domain.entity.toFavoriteBeer
import com.mv.core.core.repository.LocalConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteUseCase {

    suspend fun getAllFavoritesBeer(): List<FavoriteBeer>  {
         return withContext(Dispatchers.IO) {
            LocalConnection.getAllFavorites().first().beers.map {
                it.toFavoriteBeer()
            }
        }
    }

}