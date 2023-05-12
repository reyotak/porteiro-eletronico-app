package com.example.porteiroeletronico.main.acessos.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.create.CreateCadastro
import com.example.porteiroeletronico.main.acessos.data.DataSourceProgramados
import com.google.android.material.button.MaterialButton


class ProgramadoCardAdaptor(val context : Context?) : RecyclerView.Adapter<
        ProgramadoCardAdaptor.ProgramadoCardViewHolder>() {

    // inicializa os tipos de acordo com os ultimos acessos
    private val listaProgramados = DataSourceProgramados.programados


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ProgramadoCardViewHolder {
        //  criar o adaptador entre a ui e o codigo
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_programado, parent, false)
        return ProgramadoCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = listaProgramados.size

    override fun onBindViewHolder(holder: ProgramadoCardViewHolder, position: Int) {
        // setar a imagem e o nome de acordo com a posicao na lista
        val programadoData = listaProgramados[position]
        holder.imageView?.setImageResource(programadoData.imageResourceId)
        holder.header?.text = programadoData.data
        holder.subheader?.text = programadoData.tipo
        holder.editar?.setOnClickListener {
            if (context != null) {
                val intent = Intent(context, CreateCadastro::class.java)
                val bundle = Bundle()
                startActivity(context, intent, bundle)
            }
        }
    }

    class ProgramadoCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // declarar e inicializar os image views e buttons
        val header : TextView? = view?.findViewById(R.id.header)
        val subheader : TextView? = view?.findViewById(R.id.subhead)
        val imageView: ImageView? = view?.findViewById(R.id.tipo_cadastro_img)
        val editar: MaterialButton? = view?.findViewById(R.id.editar)
    }
}