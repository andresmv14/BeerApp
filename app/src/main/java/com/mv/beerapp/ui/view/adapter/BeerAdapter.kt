package com.mv.beerapp.ui.view.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.data.model.BeerProvider
import com.mv.beerapp.modelo.BeerItem
import com.mv.beerapp.ui.viewmodel.BeerViewModel

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
