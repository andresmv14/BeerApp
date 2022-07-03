package com.mv.beerapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.mv.beerapp.data.model.BeerModel
import com.mv.beerapp.modelo.BeerItem

@Entity
data class BeerEntity (
    @PrimaryKey
    @ColumnInfo(name= "BeerId") val Beerid:Int,
    @ColumnInfo(name ="image_url") val image:String,
    @ColumnInfo(name ="name") val name:String,
    @ColumnInfo(name ="tagline") val tagLine:String,
    @ColumnInfo(name ="description") val description:String
    )


fun BeerItem.toDatbase() = BeerEntity(Beerid,image, name, tagLine, description)