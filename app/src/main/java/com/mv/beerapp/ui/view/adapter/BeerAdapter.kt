package com.mv.beerapp.ui.view.adapter

import android.media.Image
import android.opengl.GLES31
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.data.model.BeerModel
import com.mv.beerapp.domain.getBeers
import com.mv.beerapp.ui.viewmodel.BeerViewModel
import com.squareup.picasso.Picasso

class BeerAdapter(private val beerList: List<BeerModel>, private val onClickListener: (BeerModel) -> Unit) : RecyclerView.Adapter<BeerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BeerViewHolder(layoutInflater.inflate(R.layout.item_beer, parent, false))
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val item = beerList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int {
        return beerList.size
    }



}