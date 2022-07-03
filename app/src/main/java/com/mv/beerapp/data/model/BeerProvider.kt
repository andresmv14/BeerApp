package com.mv.beerapp.data.model

class BeerProvider {
    companion object{
        var beers:List<BeerModel>? = emptyList()
        lateinit var user:String
        var id:Int = 0
       var fav: List<Int> = emptyList()
        lateinit var lisFav:List<Long>

    }

}