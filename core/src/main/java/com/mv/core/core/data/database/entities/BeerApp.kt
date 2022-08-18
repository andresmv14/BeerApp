package com.mv.core.core.data.database.entities

import android.app.Application
import androidx.room.Room

class BeerApp: Application() {
    companion object{
        lateinit var db:BeerDatabase
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            BeerDatabase::class.java,
            "Beers"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }
}