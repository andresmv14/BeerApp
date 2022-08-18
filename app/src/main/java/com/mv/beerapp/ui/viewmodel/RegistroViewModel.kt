package com.mv.beerapp.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mv.core.core.data.database.entities.BeerApp
import com.mv.core.core.data.database.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class RegistroViewModel: ViewModel() {
    val operacionExistosa = MutableLiveData<Boolean>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun guardarUsuario(user:String, pass:String){
        val encodePass: String = Base64.getEncoder().encodeToString(pass.toByteArray())
        val mUser = UserEntity(0,user,encodePass)
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                BeerApp.db.getBeerDao().insertUser(
                    arrayListOf(mUser)
                )
            }
            operacionExistosa.value = result.isNotEmpty()
        }
    }
}