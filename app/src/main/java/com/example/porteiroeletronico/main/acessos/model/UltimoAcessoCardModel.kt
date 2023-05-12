package com.example.porteiroeletronico.main.acessos.model

import androidx.annotation.DrawableRes

data class UltimoAcessoCardModel(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val tipo: String,
    val date: String,
    val aprovada: String
)