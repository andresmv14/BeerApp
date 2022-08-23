package com.mv.beers.ui.view.adapter.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mv.beers.R
import com.mv.beers.domain.entity.FavoriteBeer
import com.squareup.picasso.Picasso


class FavViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val favName: TextView = view.findViewById(R.id.tvName)
    private val tagFav: TextView = view.findViewById(R.id.tvTagLine)
    private val favImg: ImageView = view.findViewById(R.id.ivBeer)

    fun updateView(beerItem: FavoriteBeer) {
        this.favName.text = beerItem.beerName
        this.tagFav.text = beerItem.tagLine
        Picasso.get().load(beerItem.image).into(this.favImg)
    }
}