package com.mv.beerapp.data.database.entities.dao

import androidx.room.*
import com.mv.beerapp.data.database.entities.BeerEntity
import com.mv.beerapp.data.database.entities.UserBeerRef
import com.mv.beerapp.data.database.entities.UserEntity
import com.mv.beerapp.data.database.entities.UserWithBeer
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
    @Transaction
    @Insert
    suspend fun insertRelation(fav:List<UserBeerRef>):List<Long>

    @Transaction
    @Query("SELECT * FROM UserEntity WHERE UserId = :userid")
    suspend fun getUserWithBeers(userid:Int):List<UserWithBeer>
    @Transaction
    @Query("SELECT BeerId FROM UserBeerRef WHERE UserId = :idUser")
    fun getFav(idUser: Int ):List<Int>



    @Query("SELECT password FROM UserEntity WHERE usuario =:user")
    suspend fun getUsers(user:String):String

    @Query("SELECT UserId FROM UserEntity WHERE usuario =:user")
    suspend fun getId(user:String):Int


    @Update
    fun updateUser(userU:UserEntity)

    @Update
    fun updateBeer(beerU:BeerEntity)
    @NotNull
    @Delete
    suspend fun deleteFav(fav:List<UserBeerRef>)

    @Query("DELETE FROM BeerEntity")
    suspend fun deleteAllBeers()


}