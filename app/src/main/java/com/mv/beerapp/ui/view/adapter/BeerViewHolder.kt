package com.mv.beerapp.ui.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.data.model.BeerModel
import com.squareup.picasso.Picasso

class BeerViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tvName)
    val tagLine = view.findViewById<TextView>(R.id.tvTagLine)
    val imagen = view.findViewById<ImageView>(R.id.ivBeer)

    fun render(beermodel: BeerModel){
        tvName.text = beermodel.name
        tagLine.text = beermodel.tagLine
        Picasso.get().load(beermodel.image).into(imagen)
    }
}