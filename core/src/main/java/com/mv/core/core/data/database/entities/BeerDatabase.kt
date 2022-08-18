package com.mv.core.core.data.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mv.core.core.data.database.entities.dao.BeerDao

@Database(entities = [UserEntity::class, BeerEntity::class, UserBeerRef::class], version = 3, exportSchema = false)
abstract class BeerDatabase :RoomDatabase() {
    abstract fun getBeerDao():BeerDao
}