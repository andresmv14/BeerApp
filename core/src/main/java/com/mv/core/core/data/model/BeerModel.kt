package com.mv.core.core.data.model

import com.google.gson.annotations.SerializedName

data class BeerModel(@SerializedName("id") val id:Int,
                     @SerializedName("image_url") val image:String,
                     @SerializedName("name") val name:String,
                     @SerializedName("tagline") val tagLine:String,
                     @SerializedName("description") val description:String


)
