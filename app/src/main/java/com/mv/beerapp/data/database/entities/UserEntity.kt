package com.mv.beerapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UserId") val UserId:Int =0,
    @ColumnInfo(name = "usuario") val usuario:String,
    @ColumnInfo(name="password")val password:String
        )