package com.example.ejerciciobbdd

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PeliculaDao {
    @Insert
    suspend fun insertar (miPeliculas: Peliculas)

    @Delete
    suspend fun borrar(miPeliculas: Peliculas)

    @Update
    suspend fun modificar(miPeliculas: Peliculas)

    @Query("SELECT * FROM tabla_Peliculas")
    fun mostrarTodos(): Flow<List<Peliculas>>

    @Query("SELECT * FROM tabla_Peliculas WHERE id LIKE :id")
    fun buscarPorId(id:Int): Flow<Peliculas>
}