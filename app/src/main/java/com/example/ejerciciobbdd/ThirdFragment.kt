package com.example.ejerciciobbdd

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true) // ESTA LINEA PUESTA PARA MODIFICAR EL MENU (EN LOS FRAGMENTOS)

        val tvTitulo:TextView = view.findViewById(R.id.tvTitulo)
        val etnAnyo:EditText = view.findViewById(R.id.etnAnyo)
        val tvGenero:TextView = view.findViewById(R.id.tvGenero)
        val etdFechaVisionado:EditText = view.findViewById(R.id.etdFechaVisionado)
        val etnPuntuacion:EditText = view.findViewById(R.id.etnPuntuacion)
        val tvMedio:TextView = view.findViewById(R.id.tvMedio)
        val bInsertar:Button = view.findViewById(R.id.bInsertar)
        val bModificar:Button = view.findViewById(R.id.bModificar)
        val bEliminar:Button = view.findViewById(R.id.bEliminar)

        val id = arguments?.getInt("posicion") ?:-1

        if(id == -1){
            bModificar.isEnabled = false
            bEliminar.isEnabled = false
            activity?.setTitle("Insertar")
        }
        else{
            bInsertar.isEnabled = false
            activity?.setTitle("Modificar")
            (activity as MainActivity).miVM.buscarPorId(id)
            (activity as MainActivity).miVM.miPeliculas.observe(activity as MainActivity){
                it?.let {
                    tvTitulo.text = (it.titulo)
                    etnAnyo.setText(it.anyo)
                    tvGenero.text = (it.genero)
                    etdFechaVisionado.setText(it.fechaVisionado)
                    etnPuntuacion.setText(it.puntuacion)
                    tvMedio.text = (it.medio)
                }
            }

        }

        bInsertar.setOnClickListener {
            (activity as MainActivity).miVM.insertar(Peliculas(
                titulo = tvTitulo.text.toString(),
                anyo = etnAnyo.text.toString().toInt(),
                genero = tvGenero.text.toString(),
                fechaVisionado = etdFechaVisionado.text.toString(),
                puntuacion = etnPuntuacion.text.toString().toInt(),
                medio = tvMedio.text.toString()))
        }

        bEliminar.setOnClickListener {
            (activity as MainActivity).miVM.borrar(Peliculas(id,tvTitulo.text.toString()
                ,etnAnyo.text.toString().toInt(),tvGenero.text.toString(),
                etdFechaVisionado.text.toString(),etnPuntuacion.text.toString().toInt(),
                tvMedio.text.toString()))
        }

        bModificar.setOnClickListener {
            (activity as MainActivity).miVM.modificar(Peliculas(id,tvTitulo.text.toString()
                ,etnAnyo.text.toString().toInt(),tvGenero.text.toString(),
                etdFechaVisionado.text.toString(),etnPuntuacion.text.toString().toInt(),
                tvMedio.text.toString()))
        }
    }

    // MODIFICAR EL MENU
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.findItem(R.id.bEliminar).isVisible
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
    }
}