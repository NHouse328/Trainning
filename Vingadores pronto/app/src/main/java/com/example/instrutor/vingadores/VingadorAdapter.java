package com.example.instrutor.vingadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VingadorAdapter extends RecyclerView.Adapter<VingadorAdapter.ViewHolder> {

    private Context context;
    private Vingador[] vingadores;

    public VingadorAdapter(Context context, Vingador[] vingadores) {
        this.context = context;
        this.vingadores = vingadores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_recycler_vingador,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        viewHolder.imv_foto.setImageResource(vingadores[position].foto);
        viewHolder.txv_nome.setText(vingadores[position].nome);
        viewHolder.cdv_vingador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setIcon(vingadores[position].foto)
                        .setTitle(vingadores[position].nome)
                        .setMessage(vingadores[position].detalhe)
                        .setCancelable(false)
                        .setPositiveButton("OK",null)
                        .create()
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return vingadores.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imv_foto;
        private TextView txv_nome, txv_detalhe;
        private CardView cdv_vingador;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_foto    = itemView.findViewById(R.id.imv_foto);
            txv_nome    = itemView.findViewById(R.id.txv_nome);
            txv_detalhe = itemView.findViewById(R.id.txv_detalhe);
            cdv_vingador = itemView.findViewById(R.id.cdv_vingador);
        }
    }
}
