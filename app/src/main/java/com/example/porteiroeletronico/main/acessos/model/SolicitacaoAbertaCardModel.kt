package com.example.porteiroeletronico.main.acessos.model

import androidx.annotation.DrawableRes

data class SolicitacaoAbertaCardModel(
    @DrawableRes val imageResourceId: Int,
    val header: String,
    val subheader: String,
    val trailing: String
    )