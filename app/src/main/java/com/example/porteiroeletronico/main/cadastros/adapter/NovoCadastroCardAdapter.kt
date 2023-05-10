package com.example.porteiroeletronico.main.cadastros.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.create.CreateCadastro
import com.example.porteiroeletronico.main.cadastros.data.DataSourceTiposCadastros
import com.google.android.material.button.MaterialButton


class NovoCadastroCardAdapter(val context : Context?) : RecyclerView.Adapter<
        NovoCadastroCardAdapter.NovoCadastroCardViewHolder>() {

    // inicializa os tipos de acordo com os tipos de cadastros existentes do DataSource
    private val listaTiposCadastros = DataSourceTiposCadastros.tiposCadastros


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovoCadastroCardViewHolder {
        //  criar o adaptador entre a ui e o codigo
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_novo_cadastro, parent, false)
        return NovoCadastroCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = listaTiposCadastros.size

    override fun onBindViewHolder(holder: NovoCadastroCardViewHolder, position: Int) {
        // setar a imagem e o nome de acordo com a posicao na lista
        val tipoCadastroData = listaTiposCadastros[position]
        holder.imageView?.setImageResource(tipoCadastroData.imageResourceId)
        holder.button?.text = tipoCadastroData.name
        holder.button?.setOnClickListener {
            if (context != null) {
                val intent = Intent(context, CreateCadastro::class.java)
                val bundle = Bundle()
                startActivity(context, intent, bundle)
            }
        }
    }

    class NovoCadastroCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // declarar e inicializar os image views e buttons
        val imageView: ImageView? = view!!.findViewById(R.id.novo_cadastro_img)
        val button: MaterialButton? = view!!.findViewById(R.id.cadastro_button)
    }
}