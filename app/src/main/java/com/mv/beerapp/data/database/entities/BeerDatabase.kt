package com.mv.beerapp.data.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mv.beerapp.data.database.entities.dao.BeerDao

@Database(entities = [UserEntity::class, BeerEntity::class, UserBeerRef::class], version = 2, exportSchema = false)
abstract class BeerDatabase :RoomDatabase() {
    abstract fun getBeerDao():BeerDao
}