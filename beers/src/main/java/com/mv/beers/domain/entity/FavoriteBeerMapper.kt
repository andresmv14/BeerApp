package com.mv.beers.domain.entity

import com.mv.core.core.data.database.entities.BeerEntity

fun BeerEntity.toFavoriteBeer(): FavoriteBeer =
    FavoriteBeer(
        beerName = this.name,
        tagLine = this.tagLine,
        image = this.image
    )