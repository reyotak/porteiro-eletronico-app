package com.example.porteiroeletronico.main.cadastros.data

import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.main.cadastros.model.CadastradoCardModel

// TODO: usar uma api pra recuperar os veiculos ja cadastradas no banco de dados
object DataSourceVeiculosCadastrados {val listCadastrados: List<CadastradoCardModel> = listOf(
    CadastradoCardModel(
        R.drawable.twotone_directions_car_42,
        "Onix Azul"
    )
)
}