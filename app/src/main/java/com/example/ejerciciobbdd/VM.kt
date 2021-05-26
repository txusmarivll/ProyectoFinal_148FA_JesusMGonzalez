package com.example.ejerciciobbdd

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class VM(private val miRepositorio:Repositorio):ViewModel() {
    var lista: LiveData<List<Peliculas>> = miRepositorio.listaPeliculas.asLiveData()

    lateinit var miPeliculas:LiveData<Peliculas>

    fun insertar(miPeliculas: Peliculas) = viewModelScope.launch{
        miRepositorio.insertar(miPeliculas)
    }

    fun modificar(miPeliculas: Peliculas) = viewModelScope.launch{
        miRepositorio.modificar(miPeliculas)
    }

    fun borrar(miPeliculas: Peliculas) = viewModelScope.launch{
        miRepositorio.borrar(miPeliculas)
    }

    fun buscarPorId(id:Int) = viewModelScope.launch {
        miPeliculas=miRepositorio.buscarPorId(id).asLiveData()
    }
}

class PeliculasViewModelFactoria (private val repositorio: Repositorio):ViewModelProvider.Factory{
    override fun <T:ViewModel> create (modelClass:Class<T>):T{
        if(modelClass.isAssignableFrom(VM::class.java)){
            @Suppress("UNCHECKED_CAST")
            return VM(repositorio) as T
        }
        throw IllegalArgumentException("clase viewModel desconocida")
    }
}