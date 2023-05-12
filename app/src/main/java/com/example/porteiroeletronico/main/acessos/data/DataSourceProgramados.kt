package com.example.porteiroeletronico.main.acessos.data

import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.main.acessos.model.ProgramadoCardModel

// TODO: usar uma api pra recuperar os programados no banco de dados
object DataSourceProgramados { val programados: List<ProgramadoCardModel> = listOf(
    ProgramadoCardModel(
        R.drawable.baseline_coffee_42,
        "Hoje, 14h", "Visita • 3 pessoas", 3
    ),
    ProgramadoCardModel(
        R.drawable.baseline_coffee_42,
        "Hoje, 14h", "Visita • 3 pessoas", 3
    ),
    ProgramadoCardModel(
        R.drawable.baseline_coffee_42,
        "Hoje, 14h", "Visita • 3 pessoas", 3
    )
)
}