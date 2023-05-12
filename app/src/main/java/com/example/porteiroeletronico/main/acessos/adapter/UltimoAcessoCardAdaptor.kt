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
import com.example.porteiroeletronico.main.acessos.data.DataSourceUltimosAcessos
import com.google.android.material.button.MaterialButton


class UltimoAcessoCardAdaptor(val context : Context?) : RecyclerView.Adapter<
        UltimoAcessoCardAdaptor.UltimoAcessoCardViewHolder>() {

    // inicializa os tipos de acordo com os ultimos acessos
    private val listaUltimosAcessos = DataSourceUltimosAcessos.ultimosAcessos


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            UltimoAcessoCardViewHolder {
        //  criar o adaptador entre a ui e o codigo
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_ultimo_acesso, parent, false)
        return UltimoAcessoCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = listaUltimosAcessos.size

    override fun onBindViewHolder(holder: UltimoAcessoCardViewHolder, position: Int) {
        // setar a imagem e o nome de acordo com a posicao na lista
        val ultimosAcessosData = listaUltimosAcessos[position]
        holder.imageView?.setImageResource(ultimosAcessosData.imageResourceId)
        holder.header?.text = ultimosAcessosData.name
        holder.subheader?.text = ultimosAcessosData.tipo
        holder.trailing?.text = ultimosAcessosData.aprovada
        holder.date?.text =ultimosAcessosData.date
        holder.detalhes?.setOnClickListener {
            if (context != null) {
                val intent = Intent(context, CreateCadastro::class.java)
                val bundle = Bundle()
                startActivity(context, intent, bundle)
            }
        }
    }

    class UltimoAcessoCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // declarar e inicializar os image views e buttons
        val header : TextView? = view?.findViewById(R.id.header)
        val subheader : TextView? = view?.findViewById(R.id.subhead)
        val trailing : TextView? = view?.findViewById(R.id.trailing)
        val imageView: ImageView? = view?.findViewById(R.id.tipo_cadastro_img)
        val date: TextView? = view?.findViewById(R.id.date)
        val detalhes: MaterialButton? = view?.findViewById(R.id.detalhes)
    }
}