package com.mv.beerapp.ui.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.beerapp.data.database.entities.BeerApp
import com.mv.beerapp.data.database.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class RegistroViewModel: ViewModel() {
    val operacionExistosa = MutableLiveData<Boolean>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun guardarUsuario(user:String, pass:String){
        val encodePass: String = Base64.getEncoder().encodeToString(pass.toByteArray())
        Log.e("Pass base 64",encodePass)
        var mUser = UserEntity(0,user,encodePass)
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                BeerApp.db.getBeerDao().insertUser(
                    arrayListOf<UserEntity>(mUser)
                )
            }
            operacionExistosa.value = result.isNotEmpty()
        }
    }
}