package com.mv.beerapp.ui.view.adapter

import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mv.beerapp.R
import com.mv.beerapp.data.model.BeerProvider
import com.mv.beerapp.data.model.BeerProvider.Companion.fav
import com.mv.beerapp.modelo.BeerItem
import com.mv.beerapp.ui.viewmodel.BeerViewModel
import com.squareup.picasso.Picasso



class BeerViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val tvName: TextView = view.findViewById(R.id.tvName)
    private val tagLine: TextView  = view.findViewById(R.id.tvTagLine)
    private val ivImage: ImageView = view.findViewById(R.id.ivBeer)
    private val addFav: CheckBox = view.findViewById(R.id.chAddFav)

    fun render(beerItem: BeerItem, onClick: (BeerItem) -> Unit,position:Int){
        tvName.text = beerItem.name
        tagLine.text = beerItem.tagLine

        Log.e("Position",position.toString())
        addFav.isChecked = fav.contains(position+1)

        addFav.setOnClickListener {
            if(!addFav.isChecked){
                BeerViewModel().onDeleteClick(BeerProvider.id, beerItem.Beerid)
                addFav.isChecked = false
            }else{

                    BeerViewModel().onFavClick(BeerProvider.id, beerItem.Beerid)
                    addFav.isChecked = true

            }
        }
        Picasso.get().load(beerItem.image).into(ivImage)
        itemView.setOnClickListener{
            onClick(beerItem)
        }
    }
}