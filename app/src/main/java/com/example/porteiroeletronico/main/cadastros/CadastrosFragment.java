package com.example.porteiroeletronico.main.cadastros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porteiroeletronico.R;
import com.example.porteiroeletronico.databinding.FragmentCadastrosBinding;
import com.example.porteiroeletronico.main.cadastros.adapter.CadastradoCardAdaptor;
import com.example.porteiroeletronico.main.cadastros.adapter.NovoCadastroCardAdapter;
import com.example.porteiroeletronico.main.cadastros.model.CadastrosViewModel;

public class CadastrosFragment extends Fragment {

    private FragmentCadastrosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCadastrosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // seta os cards dos novos cadastros
        RecyclerView novoCadastrado = root.findViewById(R.id.recycler_view_novo_cadastro);
        novoCadastrado.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.HORIZONTAL, false));
        novoCadastrado.setAdapter(new NovoCadastroCardAdapter(getContext()));
        novoCadastrado.setHasFixedSize(true);

        // seta os cards das pessoas ja cadastradas
        RecyclerView pessoasCadastradas = root.findViewById(R.id.recycler_view_pessoas_cadastradas);
        pessoasCadastradas.setNestedScrollingEnabled(false);
        pessoasCadastradas.setLayoutManager(new GridLayoutManager(getContext(), 2));
        pessoasCadastradas.setAdapter(new CadastradoCardAdaptor(
                CadastrosViewModel.CadastroType.PESSOA, getContext()));

        // seta os cards dos adm ja cadastradas
        RecyclerView admCadastrados = root.findViewById(R.id.recycler_view_adm_cadastrados);
        admCadastrados.setNestedScrollingEnabled(false);
        admCadastrados.setLayoutManager(new GridLayoutManager(getContext(), 2));
        admCadastrados.setAdapter(new CadastradoCardAdaptor(
                CadastrosViewModel.CadastroType.ADM, getContext()));

        // seta os cards dos veiculos ja cadastradas
        RecyclerView veicCadastrados = root.findViewById(R.id.recycler_view_veiculos_cadastrados);
        veicCadastrados.setNestedScrollingEnabled(false);
        veicCadastrados.setLayoutManager(new GridLayoutManager(getContext(), 2));
        veicCadastrados.setAdapter(new CadastradoCardAdaptor(
                CadastrosViewModel.CadastroType.VEICULO, getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}