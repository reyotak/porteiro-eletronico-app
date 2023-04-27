package com.example.porteiroeletronico.ui.unidade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.porteiroeletronico.databinding.FragmentUnidadeBinding;

public class UnidadeFragment extends Fragment {

    private FragmentUnidadeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UnidadeViewModel unidadeViewModel =
                new ViewModelProvider(this).get(UnidadeViewModel.class);

        binding = FragmentUnidadeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textUnidade;
        unidadeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}