package com.mv.beerapp.data.model

import android.widget.ImageView
import com.google.gson.annotations.SerializedName

data class BeerDescription(val id:Int,
                           val image:ImageView,
                           val name:String,
                           val tagLine:String,
                           val description:String
                           ) {

}
