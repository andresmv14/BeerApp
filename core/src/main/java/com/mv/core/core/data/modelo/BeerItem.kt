package com.mv.core.core.data.modelo

import com.mv.core.core.data.database.entities.BeerEntity
import com.mv.core.core.data.model.BeerModel


data class BeerItem(
    val Beerid:Int,
    val image:String,
    val name:String,
    val tagLine:String,
    val description:String)

fun BeerModel.toDomain() = BeerItem(id,image,name,tagLine,description)
fun BeerEntity.toDomain() = BeerItem(Beerid,image,name,tagLine,description)

