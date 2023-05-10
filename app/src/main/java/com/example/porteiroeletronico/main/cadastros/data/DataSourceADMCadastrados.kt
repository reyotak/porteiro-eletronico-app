package com.example.porteiroeletronico.main.cadastros.data

import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.main.cadastros.model.CadastradoCardModel

// TODO: usar uma api pra recuperar os ADM ja cadastradas no banco de dados
object DataSourceADMCadastrados {val listCadastrados: List<CadastradoCardModel> = listOf(
    CadastradoCardModel(
        R.drawable.baseline_key_42,
        "Victor (Eu)"
    ),
    CadastradoCardModel(
        R.drawable.baseline_key_42,
        "Claudia"
    )
)
}