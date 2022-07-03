package com.mv.beerapp.ui.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.modelo.BeerItem
import com.squareup.picasso.Picasso

class FavViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val favName = view.findViewById<TextView>(R.id.tvName)
    val tagFav = view.findViewById<TextView>(R.id.tvTagLine)
    val favImg = view.findViewById<ImageView>(R.id.ivBeer)

    fun render(beerItem: BeerItem){
        favName.text = beerItem.name
        tagFav.text = beerItem.tagLine
        Picasso.get().load(beerItem.image).into(favImg)
    }
}