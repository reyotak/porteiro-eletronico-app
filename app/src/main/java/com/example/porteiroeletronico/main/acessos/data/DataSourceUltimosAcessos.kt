package com.example.porteiroeletronico.main.acessos.data

import com.example.porteiroeletronico.R
import com.example.porteiroeletronico.main.acessos.model.UltimoAcessoCardModel

// TODO: usar uma api pra recuperar as solicitacoes abertas no banco de dados
object DataSourceUltimosAcessos { val ultimosAcessos: List<UltimoAcessoCardModel> = listOf(
    UltimoAcessoCardModel(
        R.drawable.twotone_directions_car_42,
        "Ana Caetano", "Visita - Com veiculo", "17/04 • 14:00", "Aprovada | Acesso Liberado"
    ),
    UltimoAcessoCardModel(
        R.drawable.baseline_handyman_42,
        "Diarista", "Servico - Frequente", "17/04 • 14:00", "Aprovada | Acesso Liberado"
    ),
    UltimoAcessoCardModel(
        R.drawable.baseline_handyman_42,
        "Entrega Geladeira", "Servico", "17/04 • 14:00","Recusada | Morador Ausente"
    ),
    UltimoAcessoCardModel(
        R.drawable.baseline_family_restroom_42,
        "Pedro", "Visita - Familia", "17/04 • 14:00","Finalizada | Sem Resposta"
    ),
)
}