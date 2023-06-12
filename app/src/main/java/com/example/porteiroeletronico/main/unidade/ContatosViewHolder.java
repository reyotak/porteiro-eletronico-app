package com.example.porteiroeletronico.main.unidade;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porteiroeletronico.R;

public class ContatosViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView number;
    public ImageButton callButton;

    public ContatosViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.tv_contatos_nome);
        number = (TextView) itemView.findViewById(R.id.tv_contatos_numero);
        callButton = (ImageButton) itemView.findViewById(R.id.button_telefone);
    }
}
