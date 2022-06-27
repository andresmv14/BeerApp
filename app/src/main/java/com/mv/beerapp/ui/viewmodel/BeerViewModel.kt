package com.mv.beerapp.ui.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.beerapp.data.model.BeerModel
import com.mv.beerapp.data.model.BeerProvider
import com.mv.beerapp.data.model.BeerProvider.Companion.beers
import com.mv.beerapp.domain.getBeers
import com.mv.beerapp.ui.view.principalFragment


import kotlinx.coroutines.launch
import kotlin.math.log

class BeerViewModel : ViewModel() {
    val beerModel = MutableLiveData<List<BeerModel>>()
    //val beerDetail = MutableLiveData<BeerModel>()
    val getBeers = getBeers()
    fun onCreate(){
        viewModelScope.launch {
            val result = getBeers()

            if(!result.isNullOrEmpty()) {
                Log.e("Succes", result.toString())
                beerModel.postValue(result)
            }else{
                Log.e("Error","Vacia")
            }

        }
    }
    val beerDetail = MutableLiveData<BeerModel>()
    fun onBeerClicked(BeerD: BeerModel){
        Log.e("Si es correcto",BeerD.toString())
            beerDetail.value=BeerD
        Log.e("BeerDetail",beerDetail.value.toString())


    }


}