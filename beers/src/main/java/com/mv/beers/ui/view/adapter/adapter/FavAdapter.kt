package com.mv.beers.ui.view.adapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mv.beers.R
import com.mv.beers.domain.entity.FavoriteBeer


class FavAdapter : RecyclerView.Adapter<FavViewHolder>() {

    private var lstFavBeers: List<FavoriteBeer>? = null

    fun setDataInRecycler(lstItems: List<FavoriteBeer>) {
        this.lstFavBeers = lstItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavViewHolder(layoutInflater.inflate(R.layout.item_beer_fav, parent, false))
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        this.lstFavBeers?.let {
            holder.updateView(it[position])
        }
    }

    override fun getItemCount(): Int {
        return this.lstFavBeers?.size ?: 0
    }
}