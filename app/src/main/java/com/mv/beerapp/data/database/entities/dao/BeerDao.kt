package com.mv.beerapp.data.database.entities.dao

import androidx.room.*
import com.mv.beerapp.data.database.entities.BeerEntity
import com.mv.beerapp.data.database.entities.UserBeerRef
import com.mv.beerapp.data.database.entities.UserEntity
import com.mv.beerapp.data.database.entities.UserWithBeer
import com.mv.beerapp.modelo.BeerItem
import org.jetbrains.annotations.NotNull

@Dao
interface BeerDao {

    @Query("SELECT * FROM BeerEntity")
    suspend fun getAllBeers():List<BeerEntity>
    @NotNull
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserBeers(beer:List<BeerEntity>)
    @NotNull
    @Insert
    suspend fun insertUser(user:List<UserEntity>):List<Long>
    @NotNull
    @Insert
    suspend fun insertRelation(fav:List<UserBeerRef>)

    @Transaction
    @Query("SELECT * FROM UserEntity WHERE UserId = :id")
    suspend fun getUserWithBeers(id: Int):List<UserWithBeer>


    @Query("SELECT password FROM UserEntity WHERE usuario =:user")
    suspend fun getUsers(user:String):String


    @Update
    fun updateUser(userU:UserEntity)

    @Update
    fun updateBeer(beerU:BeerEntity)
    @NotNull
    @Delete
    fun deleteFav(fav:List<UserBeerRef>)

    @Query("DELETE FROM BeerEntity")
    suspend fun deleteAllBeers()


}