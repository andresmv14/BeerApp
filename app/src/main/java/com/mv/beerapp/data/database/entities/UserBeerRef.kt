package com.mv.beerapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["UserId","BeerId"])
data class UserBeerRef(
    @ColumnInfo(name = "UserId") val UserId:Int,
    @ColumnInfo(index = true) val BeerId:Int)
