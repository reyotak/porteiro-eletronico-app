package com.example.porteiroeletronico.ui.cadastros;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CadastrosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CadastrosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cadastros fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}