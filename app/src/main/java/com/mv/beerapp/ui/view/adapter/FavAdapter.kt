package com.mv.beerapp.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.modelo.BeerItem

class FavAdapter(private val beerList: List<BeerItem>): RecyclerView.Adapter<FavViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavViewHolder(layoutInflater.inflate(R.layout.item_beer_fav, parent, false))
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val item = beerList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return beerList.size
    }
}