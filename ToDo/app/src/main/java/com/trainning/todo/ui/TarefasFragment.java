package com.trainning.todo.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.trainning.todo.R;
import com.trainning.todo.TarefasAdapter;
import com.trainning.todo.model.Constantes;
import com.trainning.todo.model.Tarefa;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TarefasFragment extends Fragment {

    private RecyclerView rcv_tarefas;

    private DatabaseReference ref;

    public TarefasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tarefas, container, false);

        rcv_tarefas = rootView.findViewById(R.id.rcv_tarefas);
        ref = FirebaseDatabase.getInstance().getReference();

        getDB();

        return rootView;
    }

    private void getDB() {
        String uid = FirebaseAuth.getInstance().getUid();
        ref.child(Constantes.TABELA_TAREFAS)
                .child(uid)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ArrayList<Tarefa> tarefas = new ArrayList<>();

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Tarefa tarefa = snapshot.getValue(Tarefa.class);
                            tarefas.add(tarefa);

                            RecyclerView.LayoutManager menager = new LinearLayoutManager(
                                    getContext(),
                                    LinearLayoutManager.VERTICAL,
                                    false
                            );

                            rcv_tarefas.setLayoutManager(menager);

                            TarefasAdapter adapter = new TarefasAdapter(getContext(),tarefas);
                            rcv_tarefas.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

}
