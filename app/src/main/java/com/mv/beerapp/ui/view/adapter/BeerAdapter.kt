package com.mv.beerapp.ui.view.adapter

import android.media.Image
import android.opengl.GLES31
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.data.database.entities.BeerApp
import com.mv.beerapp.data.model.BeerModel
import com.mv.beerapp.data.model.BeerProvider
import com.mv.beerapp.domain.getBeers
import com.mv.beerapp.modelo.BeerItem
import com.mv.beerapp.ui.viewmodel.BeerViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeerAdapter(private val beerList: List<BeerItem>, private val onClickListener: (BeerItem) -> Unit) : RecyclerView.Adapter<BeerViewHolder>(){

    init {
        BeerViewModel().fav(BeerProvider.id)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BeerViewHolder(layoutInflater.inflate(R.layout.item_beer, parent, false))
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        val item = beerList[position]

        holder.render(item, onClickListener,position)
    }

    override fun getItemCount(): Int {
        return beerList.size
    }

    }
