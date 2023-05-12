package com.example.porteiroeletronico.main.acessos.data

import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.main.acessos.model.SolicitacaoAbertaCardModel

// TODO: usar uma api pra recuperar os ADM ja cadastradas no banco de dados
object DataSourceSolicitacoesAbertas { val solicitacoes: List<SolicitacaoAbertaCardModel> = listOf(
    SolicitacaoAbertaCardModel(
        R.drawable.baseline_family_restroom_32,
        "Jardineiro", "Serviço - Frequente", "Há 2 min"
    ),
    SolicitacaoAbertaCardModel(
        R.drawable.baseline_handyman_32,
        "Claudia", "Familia - Visita", "Há 5 min"
    )
)
}