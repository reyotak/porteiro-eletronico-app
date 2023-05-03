package com.example.porteiroeletronico.ui.cadastros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porteiroeletronico.R;
import com.example.porteiroeletronico.databinding.FragmentCadastrosBinding;
import com.example.porteiroeletronico.ui.cadastros.adapter.NovoCadastroCardAdapter;
import com.example.porteiroeletronico.ui.cadastros.model.CadastrosViewModel;

public class CadastrosFragment extends Fragment {

    private FragmentCadastrosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CadastrosViewModel cadastrosViewModel =
                new ViewModelProvider(this).get(CadastrosViewModel.class);

        binding = FragmentCadastrosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // seta o texto abaixo da top bar
        final TextView textView = binding.textCadastros;
        cadastrosViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // seta os cards dos novos cadastros
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(new NovoCadastroCardAdapter());
        recyclerView.setHasFixedSize(true);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}