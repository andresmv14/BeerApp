package com.mv.beerapp.ui.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.core.core.data.database.entities.BeerApp
import com.mv.core.core.data.database.entities.UserBeerRef
import com.mv.core.core.data.model.BeerProvider

import com.mv.beerapp.domain.GetBeers
import com.mv.core.core.data.modelo.BeerItem
import kotlinx.coroutines.*



class BeerViewModel : ViewModel() {
    val beerModel = MutableLiveData<List<BeerItem>>()
    //val beerDetail = MutableLiveData<BeerModel>()
    val getBeers = GetBeers()
    fun onCreate(){
        viewModelScope.launch {
            val result = getBeers()
            val id = withContext(Dispatchers.IO){
                BeerApp.db.getBeerDao().getId(BeerProvider.user)
            }
            BeerProvider.id = id
            if(result.isNotEmpty()) {
                beerModel.postValue(result)
            }else{
                Log.e("Error","Vacia")
            }

        }
    }
    val beerDetail = MutableLiveData<BeerItem>()
    fun onBeerClicked(BeerD: BeerItem){
            beerDetail.value=BeerD



        }
    fun fav(userId:Int){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                BeerApp.db.getBeerDao().getFav(userId)
            }
            BeerProvider.fav=result

        }
    }
    fun onFavClick(userId:Int, beerId:Int) {
        val mFav = UserBeerRef(userId, beerId)
        viewModelScope.launch {
                BeerApp.db.getBeerDao().insertRelation(
                    arrayListOf(mFav)
                )
            }
        }

    fun onDeleteClick(userId:Int, beerId:Int){
        val mFav = UserBeerRef(userId, beerId)
        viewModelScope.launch {
            BeerApp.db.getBeerDao().deleteFav(
                arrayListOf(mFav)
            )
        }
    }
    }



