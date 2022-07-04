package com.mv.beerapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.beerapp.data.database.entities.BeerApp
import com.mv.beerapp.data.database.entities.BeerEntity
import com.mv.beerapp.data.model.BeerProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritosViewModel:ViewModel() {
    val beerFavoritos = MutableLiveData<List<BeerEntity>>()

    fun onCreate(){
        viewModelScope.launch{
            val result = withContext(Dispatchers.IO){
                BeerApp.db.getBeerDao().getUserWithBeers(BeerProvider.id)
            }
            if (!result.isNullOrEmpty()){

                beerFavoritos.postValue(result.first().beers)
            }else{
                Log.e("Lista de favoritos: ", beerFavoritos.toString())
            }
        }
    }
}