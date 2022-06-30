package com.mv.beerapp.data.database.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithBeer(
    @Embedded val favoritos: UserEntity,
    @Relation(
        parentColumn = "UserId",
        entityColumn = "BeerId",
        associateBy = Junction(UserBeerRef::class)
    )
    val beers:List<BeerEntity>
)
