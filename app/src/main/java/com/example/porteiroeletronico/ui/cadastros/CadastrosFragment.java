package com.example.porteiroeletronico.ui.cadastros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.porteiroeletronico.databinding.FragmentCadastrosBinding;

public class CadastrosFragment extends Fragment {

    private FragmentCadastrosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CadastrosViewModel cadastrosViewModel =
                new ViewModelProvider(this).get(CadastrosViewModel.class);

        binding = FragmentCadastrosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCadastros;
        cadastrosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}