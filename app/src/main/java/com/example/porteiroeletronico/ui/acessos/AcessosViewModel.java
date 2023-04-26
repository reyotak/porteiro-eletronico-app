package com.example.porteiroeletronico.ui.acessos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AcessosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AcessosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is acessos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}