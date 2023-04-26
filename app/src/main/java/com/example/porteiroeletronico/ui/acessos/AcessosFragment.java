package com.example.porteiroeletronico.ui.acessos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.porteiroeletronico.databinding.FragmentAcessosBinding;

public class AcessosFragment extends Fragment {

    private FragmentAcessosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AcessosViewModel acessosViewModel =
                new ViewModelProvider(this).get(AcessosViewModel.class);

        binding = FragmentAcessosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAcessos;
        acessosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}