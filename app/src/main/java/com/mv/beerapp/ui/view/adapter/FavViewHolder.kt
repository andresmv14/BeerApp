package com.mv.beerapp.ui.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.core.core.data.database.entities.BeerEntity
import com.squareup.picasso.Picasso


class FavViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val favName: TextView  = view.findViewById(R.id.tvName)
    private val tagFav: TextView  = view.findViewById(R.id.tvTagLine)
    private val favImg: ImageView = view.findViewById(R.id.ivBeer)

    fun render(beerItem: BeerEntity){
        favName.text = beerItem.name
        tagFav.text = beerItem.tagLine
        Picasso.get().load(beerItem.image).into(favImg)
    }
}