package com.example.ejerciciobbdd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = arrayOf(Peliculas::class), version=1, exportSchema = false)
abstract class PeliculasDataBase: RoomDatabase() {

    abstract fun miDao():PeliculaDao

    companion object{

        @Volatile
        private var INSTANCE: PeliculasDataBase?=null

        fun getDataBase(context : Context): PeliculasDataBase{
            return INSTANCE ?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    PeliculasDataBase::class.java,
                    "peliculas_database"
                ).build()
                INSTANCE=instance
                instance
            }
        }
    }
}