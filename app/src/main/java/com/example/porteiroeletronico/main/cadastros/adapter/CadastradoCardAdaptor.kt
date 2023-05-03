package com.example.porteiroeletronico.main.cadastros.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.main.cadastros.data.DataSourceCadastrados

class CadastradoCardAdaptor : RecyclerView.Adapter<
        CadastradoCardAdaptor.CadastradoCardViewHolder>() {

    // inicializa quem ja esta cadastrado do data source
    private val listaCadastrados = DataSourceCadastrados.listCadastrados


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CadastradoCardViewHolder {
        //  criar o adaptador entre a ui e o codigo
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_cadastrados, parent, false)
        return CadastradoCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = listaCadastrados.size

    override fun onBindViewHolder(holder: CadastradoCardViewHolder, position: Int) {
        // setar a imagem e o nome de acordo com a posicao na lista
        val tipoCadastroData = listaCadastrados[position]
        holder.imageView?.setImageResource(tipoCadastroData.imageResourceId)
        holder.name?.text = tipoCadastroData.name
    }

    class CadastradoCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // declarar e inicializar os image views e buttons
        val imageView: ImageView? = view!!.findViewById(R.id.tipo_cadastro_img)
        val name: TextView? = view!!.findViewById(R.id.nome_cadastrado)
    }
}