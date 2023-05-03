package com.example.porteiroeletronico.main.cadastros.data

import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.main.cadastros.model.CadastradoCardModel

object DataSourceCadastrados {val listCadastrados: List<CadastradoCardModel> = listOf(
    CadastradoCardModel(
        R.drawable.baseline_handyman_42,
        "Diarista"
    ),
    CadastradoCardModel(
        R.drawable.baseline_handyman_42,
        "Jardineiro"
    ),
    CadastradoCardModel(
        R.drawable.baseline_family_restroom_42,
        "Pedro"
    )
)
}