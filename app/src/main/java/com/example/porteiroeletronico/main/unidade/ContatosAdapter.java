package com.example.porteiroeletronico.main.unidade;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.porteiroeletronico.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ContatosAdapter extends RecyclerView.Adapter<ContatosViewHolder> {

    private final List<ContatosModel> mContatos;

    public ContatosAdapter(ArrayList contatos) {
        mContatos = contatos;
    }

    @NonNull
    @Override
    public ContatosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContatosViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_contatos, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContatosViewHolder holder, int position) {
        holder.name.setText(mContatos.get(position).getName());
        holder.number.setText(mContatos.get(position).getNumber());

        holder.callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToDialContact = new Intent(Intent.ACTION_DIAL);
                String numberToDial = (String) holder.number.getText();
                Context context = holder.callButton.getContext();

                intentToDialContact.setData(Uri.parse("tel:" + numberToDial));
                context.startActivity(intentToDialContact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContatos != null ? mContatos.size() : 0;
    }
}
