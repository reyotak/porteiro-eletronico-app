package com.example.porteiroeletronico.main.cadastros.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.create.CreateCadastro
import com.example.porteiroeletronico.main.cadastros.data.DataSourceADMCadastrados
import com.example.porteiroeletronico.main.cadastros.data.DataSourcePessoasCadastradas
import com.example.porteiroeletronico.main.cadastros.data.DataSourceVeiculosCadastrados
import com.example.porteiroeletronico.main.cadastros.model.CadastrosViewModel
import com.google.android.material.button.MaterialButton


class CadastradoCardAdaptor(val cadastroType : CadastrosViewModel.CadastroType,
                            private val context : Context?) :
    RecyclerView.Adapter<CadastradoCardAdaptor.CadastradoCardViewHolder>() {

    // inicializa quem ja esta cadastrado do data source
    private val dataList = when (cadastroType) {
        CadastrosViewModel.CadastroType.PESSOA -> DataSourcePessoasCadastradas.listCadastrados
        CadastrosViewModel.CadastroType.ADM -> DataSourceADMCadastrados.listCadastrados
        CadastrosViewModel.CadastroType.VEICULO -> DataSourceVeiculosCadastrados.listCadastrados
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CadastradoCardViewHolder {
        //  criar o adaptador entre a ui e o codigo
        val adapterLayout = when (viewType) {
            R.layout.card_add -> LayoutInflater.from(parent.context)
                .inflate(R.layout.card_add, parent, false)
            else -> LayoutInflater.from(parent.context)
                .inflate(R.layout.card_cadastrados, parent, false)
        }
        return CadastradoCardViewHolder(adapterLayout)
    }

    override fun getItemCount() = when (cadastroType) {
        CadastrosViewModel.CadastroType.PESSOA -> dataList.size
        else -> dataList.size + 1
    }

    override fun onBindViewHolder(holder: CadastradoCardViewHolder, position: Int) {
        when (position) {
            dataList.size -> holder.button?.setOnClickListener {
                if (context != null) {
                    val intent = Intent(context, CreateCadastro::class.java)
                    val bundle = Bundle()
                    ContextCompat.startActivity(context, intent, bundle)
                }
            }
            else -> {
                val tipoCadastroData = dataList[position]
                holder.imageView?.setImageResource(tipoCadastroData.imageResourceId)
                holder.name?.text = tipoCadastroData.name
                holder.detalhesButton?.setOnClickListener {
                    if (context != null) {
                        val intent = Intent(context, CreateCadastro::class.java)
                        val bundle = Bundle()
                        ContextCompat.startActivity(context, intent, bundle)
                    }
                }
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            dataList.size -> R.layout.card_add
            else -> R.layout.card_cadastrados
        }
    }

    class CadastradoCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // declarar e inicializar os image views e buttons
        val imageView: ImageView? = view!!.findViewById(R.id.tipo_cadastro_img)
        val name: TextView? = view!!.findViewById(R.id.nome_cadastrado)
        val button: MaterialButton? = view!!.findViewById(R.id.plus_card_button)
        val detalhesButton: MaterialButton? = view!!.findViewById(R.id.detalhes_button)
    }
}