package com.mv.beerapp.modelo

import com.mv.beerapp.data.database.entities.BeerEntity
import com.mv.beerapp.data.model.BeerModel


data class BeerItem(
    val Beerid:Int,
    val image:String,
    val name:String,
    val tagLine:String,
    val description:String)

fun BeerModel.toDomain() = BeerItem(id,image,name,tagLine,description)
fun BeerEntity.toDomain() = BeerItem(Beerid,image,name,tagLine,description)

