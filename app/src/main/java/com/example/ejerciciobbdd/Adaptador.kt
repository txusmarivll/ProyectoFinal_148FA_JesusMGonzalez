package com.example.ejerciciobbdd

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class Adaptador(var listaPeliculas: List<Peliculas>, val actividad: Activity):RecyclerView.Adapter<Adaptador.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvTitulo: TextView
        var tvAnyo: TextView
        var tvGenero: TextView
        var tvFechaVisionado: TextView
        var tvPuntuacion: TextView
        var tvMedio: TextView
        var id:Int

        init {
            tvTitulo = v.findViewById(R.id.item_tvTitulo)
            tvAnyo = v.findViewById(R.id.item_tvAnyo)
            tvGenero = v.findViewById(R.id.item_tvGenero)
            tvFechaVisionado = v.findViewById(R.id.item_tvFechaVisionado)
            tvPuntuacion = v.findViewById(R.id.item_tvPuntuacion)
            tvMedio = v.findViewById(R.id.item_tvMedio)
            id = 0
            v.setOnClickListener {
                val bundle = bundleOf("posicion" to this.id)
                actividad.findNavController(R.id.nav_host_fragment).navigate(R.id.action_SecondFragment_to_thirdFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitulo.text = listaPeliculas[position].titulo
        holder.tvAnyo.text = listaPeliculas[position].anyo.toString()
        holder.tvGenero.text = listaPeliculas[position].genero
        holder.tvFechaVisionado.text = listaPeliculas[position].fechaVisionado
        holder.tvPuntuacion.text = listaPeliculas[position].puntuacion.toString()
        holder.tvMedio.text = listaPeliculas[position].medio
        holder.id = listaPeliculas[position].id
    }

    override fun getItemCount(): Int {
        return listaPeliculas.count()
    }
}