package com.example.porteiroeletronico.ui.cadastros.data

import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.ui.cadastros.model.NovoCadastroCardModel

object DataSourceTiposCadastros {val tiposCadastros: List<NovoCadastroCardModel> = listOf(
    NovoCadastroCardModel(
        R.drawable.baseline_handyman_32,
        "Serviço"
    ),
    NovoCadastroCardModel(
        R.drawable.baseline_family_restroom_32,
        "Família"
    ),
    NovoCadastroCardModel(
        R.drawable.baseline_coffee_32,
        "Visita"
    )
)
}