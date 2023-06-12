package com.example.porteiroeletronico.main.unidade;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porteiroeletronico.R;
import com.example.porteiroeletronico.databinding.FragmentUnidadeBinding;
import com.example.porteiroeletronico.main.cadastros.adapter.CadastradoCardAdaptor;
import com.example.porteiroeletronico.main.cadastros.model.CadastrosViewModel;

import java.util.ArrayList;

public class UnidadeFragment extends Fragment {

    private FragmentUnidadeBinding binding;
    RecyclerView mRecyclerView;
    private ContatosAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UnidadeViewModel unidadeViewModel =
                new ViewModelProvider(this).get(UnidadeViewModel.class);

        binding = FragmentUnidadeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textUnidade;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view_contatos);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList<ContatosModel> contatos = initContacts();
        mAdapter = new ContatosAdapter(contatos);
        mRecyclerView.setAdapter(mAdapter);

        unidadeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private ArrayList<ContatosModel> initContacts() {
        ArrayList<ContatosModel> list = new ArrayList<>();

        list.add(new ContatosModel("Portaria", "(19) 99999-9999"));
        list.add(new ContatosModel("Administradora", "(19) 99988-9999"));

        return list;
    }

    private void callContact() {

    }
}