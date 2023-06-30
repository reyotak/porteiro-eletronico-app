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
import com.example.porteiroeletronico.main.MainActivity
import com.example.porteiroeletronico.main.acessos.data.DataSourceSolicitacoesAbertas
import com.google.android.material.button.MaterialButton


class SolicitacaoAbertaAdaptor(val context : Context?) : RecyclerView.Adapter<
        SolicitacaoAbertaAdaptor.SolicitacaoAbertaCardViewHolder>() {

    // inicializa os tipos de acordo com os tipos de cadastros existentes do DataSource
    private val listaTiposCadastros = DataSourceSolicitacoesAbertas.solicitacoes


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            SolicitacaoAbertaCardViewHolder {
        //  criar o adaptador entre a ui e o codigo
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_solicitacao_aberta, parent, false)
        return SolicitacaoAbertaCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = listaTiposCadastros.size

    override fun onBindViewHolder(holder: SolicitacaoAbertaCardViewHolder, position: Int) {
        // setar a imagem e o nome de acordo com a posicao na lista
        val tipoCadastroData = listaTiposCadastros[position]
        holder.header?.text = tipoCadastroData.header
        holder.subheader?.text = tipoCadastroData.subheader
        holder.trailing?.text = tipoCadastroData.trailing
        holder.imageView?.setImageResource(tipoCadastroData.imageResourceId)
        holder.aprovar?.setOnClickListener {
            if (context != null) {
                // Remover o item da lista de dados
                listaTiposCadastros.removeAt(position);

                // Notificar o adaptador sobre a remoção do item
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, listaTiposCadastros.size);
            }
        }
        holder.detalhes?.setOnClickListener {
            if (context != null) {
                val intent = Intent(context, CreateCadastro::class.java)
                val bundle = Bundle()
                startActivity(context, intent, bundle)
            }
        }
    }

    class SolicitacaoAbertaCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // declarar e inicializar os image views e buttons
        val header : TextView? = view?.findViewById(R.id.header)
        val subheader : TextView? = view?.findViewById(R.id.subhead)
        val trailing : TextView? = view?.findViewById(R.id.trailing)
        val imageView: ImageView? = view?.findViewById(R.id.tipo_cadastro_img)
        val aprovar: MaterialButton? = view?.findViewById(R.id.aprovar)
        val detalhes: MaterialButton? = view?.findViewById(R.id.detalhes)
    }
}