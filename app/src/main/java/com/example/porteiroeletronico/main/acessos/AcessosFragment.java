package com.example.porteiroeletronico.main.acessos;

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
import com.example.porteiroeletronico.databinding.FragmentAcessosBinding;
import com.example.porteiroeletronico.main.acessos.adapter.ProgramadoCardAdaptor;
import com.example.porteiroeletronico.main.acessos.adapter.SolicitacaoAbertaAdaptor;
import com.example.porteiroeletronico.main.acessos.adapter.UltimoAcessoCardAdaptor;
import com.example.porteiroeletronico.main.cadastros.adapter.NovoCadastroCardAdapter;

public class AcessosFragment extends Fragment {

    private FragmentAcessosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAcessosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // seta os cards de solicitacoes abertas
        RecyclerView solicitacoesAbertas =
                root.findViewById(R.id.recycler_view_solicitacoes_abertas);
        solicitacoesAbertas.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.HORIZONTAL, false));
        solicitacoesAbertas.setAdapter(new SolicitacaoAbertaAdaptor(getContext()));

        // seta os cards de programados
        RecyclerView programados =
                root.findViewById(R.id.recycler_view_programados);
        programados.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.HORIZONTAL, false));
        programados.setAdapter(new ProgramadoCardAdaptor(getContext()));

        // seta os cards de ultimos acessos
        RecyclerView ultimosAcessos =
                root.findViewById(R.id.recycler_view_ultimos_acessos);
        ultimosAcessos.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false));
        ultimosAcessos.setAdapter(new UltimoAcessoCardAdaptor(getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}