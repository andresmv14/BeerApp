package com.mv.beerapp.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.core.core.data.database.entities.BeerApp
import com.mv.core.core.data.model.BeerProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class LoginViewModel: ViewModel() {
    val loginCorrecto = MutableLiveData<Boolean>()


    @RequiresApi(Build.VERSION_CODES.O)
    fun loginUser(user:String,pass:String){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                BeerApp.db.getBeerDao().getUsers(user)

            }

            if (!result.isNullOrEmpty()) {
                val decodedBytes = Base64.getDecoder().decode(result)
                val decodedString = String(decodedBytes)
                if (decodedString == pass){
                    loginCorrecto.postValue(true)
                    BeerProvider.user = user
                }else{
                    loginCorrecto.postValue(false)
                }

            }else{
                loginCorrecto.postValue(false)
            }
        }

    }

}