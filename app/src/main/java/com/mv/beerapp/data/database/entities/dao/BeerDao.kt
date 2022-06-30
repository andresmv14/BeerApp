package com.mv.beerapp.data.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mv.beerapp.data.database.entities.BeerEntity
import com.mv.beerapp.data.database.entities.UserEntity
import com.mv.beerapp.data.database.entities.UserWithBeer

@Dao
interface BeerDao {
    @Insert
    suspend fun inserBeers(beer:List<BeerEntity>)

    @Insert
    suspend fun insertUser(user:List<UserEntity>)

    @Transaction
    @Query("SELECT * FROM UserEntity")
    suspend fun getUserWithBeers():List<UserWithBeer>
}