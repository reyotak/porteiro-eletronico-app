package com.example.porteiroeletronico.main.cadastros.model

import androidx.annotation.DrawableRes

data class NovoCadastroCardModel(
    @DrawableRes val imageResourceId: Int,
    val name: String
    )