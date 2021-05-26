package com.example.ejerciciobbdd

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_Peliculas")
class Peliculas (
    @PrimaryKey (autoGenerate = true) var id:Int,
    @NonNull @ColumnInfo(name = "titulo") var titulo:String,
    @NonNull @ColumnInfo(name = "anyo") var anyo:Int,
    @NonNull @ColumnInfo(name = "genero") var genero:String,
    @NonNull @ColumnInfo(name = "fechaVisionado")var fechaVisionado:String,
    @NonNull @ColumnInfo(name = "puntuacion") var puntuacion:Int,
    @NonNull @ColumnInfo(name = "medio") var medio:String
    ) {}