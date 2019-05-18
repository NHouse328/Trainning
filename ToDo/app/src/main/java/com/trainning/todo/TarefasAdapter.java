package com.trainning.todo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trainning.todo.model.Tarefa;

import java.util.ArrayList;

public class TarefasAdapter extends RecyclerView.Adapter<TarefasAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Tarefa> tarefas;

    public TarefasAdapter(Context context, ArrayList<Tarefa> tarefas) {
        this.context = context;
        this.tarefas = tarefas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.view_recycler_tarefa,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.txv_titulo   .setText(tarefas.get(position).getTitulo()  );
        viewHolder.txv_data     .setText(tarefas.get(position).getData()    );
        viewHolder.txv_hora     .setText(tarefas.get(position).getHora()    );

        viewHolder.cdv_tarefa   .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle   (tarefas.get(position).getTitulo()      )
                        .setMessage (tarefas.get(position).getAnotacoes()   )
                        .setPositiveButton("Ok", null)
                        .create()
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txv_data, txv_hora, txv_titulo;
        private CardView cdv_tarefa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txv_data    = itemView.findViewById(R.id.txv_data   );
            txv_hora    = itemView.findViewById(R.id.txv_hora   );
            txv_titulo  = itemView.findViewById(R.id.txv_titulo );
            cdv_tarefa  = itemView.findViewById(R.id.cdv_tarefa );

        }
    }

}
