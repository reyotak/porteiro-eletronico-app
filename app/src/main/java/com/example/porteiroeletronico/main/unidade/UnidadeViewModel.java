package com.example.porteiroeletronico.main.unidade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UnidadeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UnidadeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Informações da Unidade");
    }

    public LiveData<String> getText() {
        return mText;
    }
}