package com.example.porteiroeletronico.main.acessos.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AcessosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AcessosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Solicitações Abertas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}