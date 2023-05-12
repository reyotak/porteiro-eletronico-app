package com.example.porteiroeletronico.main.acessos.model

import androidx.annotation.DrawableRes

data class ProgramadoCardModel(
    @DrawableRes val imageResourceId: Int,
    val data: String,
    val tipo: String,
    val quantidade: Int
)