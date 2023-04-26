package com.example.porteiroeletronico.ui.unidade;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UnidadeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public UnidadeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is unidade fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}