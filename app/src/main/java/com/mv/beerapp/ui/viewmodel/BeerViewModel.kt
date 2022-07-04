package com.mv.beerapp.ui.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.beerapp.data.database.entities.BeerApp
import com.mv.beerapp.data.database.entities.UserBeerRef
import com.mv.beerapp.data.model.BeerProvider

import com.mv.beerapp.domain.getBeers
import com.mv.beerapp.modelo.BeerItem
import kotlinx.coroutines.*


import kotlin.math.log

class BeerViewModel : ViewModel() {
    val beerModel = MutableLiveData<List<BeerItem>>()
    val check = MutableLiveData<Boolean>()
    //val beerDetail = MutableLiveData<BeerModel>()
    val getBeers = getBeers()
    fun onCreate(){
        viewModelScope.launch {
            val result = getBeers()
            val id = withContext(Dispatchers.IO){
                BeerApp.db.getBeerDao().getId(BeerProvider.user)
            }
            BeerProvider.id = id
            if(!result.isNullOrEmpty()) {
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
    fun OnfavClick(userId:Int, beerId:Int) {
        var mFav = UserBeerRef(userId, beerId)
        viewModelScope.launch {
                BeerApp.db.getBeerDao().insertRelation(
                    arrayListOf<UserBeerRef>(mFav)
                )
            }
        }

    fun OnDeleteClick(userId:Int, beerId:Int){
        var mFav = UserBeerRef(userId, beerId)
        viewModelScope.launch {
            BeerApp.db.getBeerDao().deleteFav(
                arrayListOf<UserBeerRef>(mFav)
            )
        }
    }
    }



