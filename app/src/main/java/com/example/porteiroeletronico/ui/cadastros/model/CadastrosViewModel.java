package com.example.porteiroeletronico.ui.cadastros.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CadastrosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cadastrar novo acesso para");
    }

    public LiveData<String> getText() {
        return mText;
    }
}