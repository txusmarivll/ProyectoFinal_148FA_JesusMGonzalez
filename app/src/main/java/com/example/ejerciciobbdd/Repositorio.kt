package com.example.ejerciciobbdd

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class Repositorio(val miDao: PeliculaDao) {

    val listaPeliculas: Flow<List<Peliculas>> = miDao.mostrarTodos()

    @Suppress ("RedudantSuspendModifier")
    @WorkerThread
    suspend fun insertar (miPeliculas: Peliculas){
        miDao.insertar(miPeliculas)
    }

    @Suppress ("RedudantSuspendModifier")
    @WorkerThread
    suspend fun borrar (miPeliculas: Peliculas){
        miDao.borrar(miPeliculas)
    }

    @Suppress ("RedudantSuspendModifier")
    @WorkerThread
    suspend fun modificar(miPeliculas: Peliculas){
        miDao.modificar(miPeliculas)
    }

    @Suppress ("RedudantSuspendModifier")
    @WorkerThread
    fun buscarPorId(id:Int):Flow<Peliculas>{
        return miDao.buscarPorId(id)
    }
}
