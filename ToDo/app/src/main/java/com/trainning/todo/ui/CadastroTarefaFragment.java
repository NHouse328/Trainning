package com.trainning.todo.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.trainning.todo.BaseFragment;
import com.trainning.todo.R;
import com.trainning.todo.model.Constantes;
import com.trainning.todo.model.Tarefa;


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroTarefaFragment extends BaseFragment {

    private EditText            edt_titulo          ,
                                edt_data            ,
                                edt_hora            ,
                                edt_anotacoes       ;
    private Button              btn_salvar          ;
    private DatabaseReference   databaseReference   ;

    public CadastroTarefaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cadastro_tarefa, container, false);

        bindView(rootView);
        salvar();

        return rootView;
    }

    private void bindView(View rootView) {
        edt_data            = rootView.findViewById(R.id.edt_data           );
        edt_anotacoes       = rootView.findViewById(R.id.edt_anotacoes      );
        edt_hora            = rootView.findViewById(R.id.edt_hora           );
        edt_titulo          = rootView.findViewById(R.id.edt_titulo         );
        btn_salvar          = rootView.findViewById(R.id.btn_salvar         );

        databaseReference   = FirebaseDatabase.getInstance().getReference();
    }

    private void capturar() {
        String titulo       = edt_titulo.getEditableText().toString().trim();
        String data         = edt_data.getEditableText().toString().trim();
        String hora         = edt_titulo.getEditableText().toString().trim();
        String anotacoes    = edt_anotacoes.getEditableText().toString().trim();

        String uid          = FirebaseAuth.getInstance().getUid();
        String tarefaId    = databaseReference.push().getKey();

        Tarefa tarefa = new Tarefa(titulo,data,hora,anotacoes,tarefaId);

        if (uid != null && tarefaId != null) {
            databaseReference.child(Constantes.TABELA_TAREFAS)
                .child(uid)
                .child(tarefaId)
                .setValue(tarefa)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            showAlert("Tarefa " + edt_titulo.getEditableText().toString().trim(),"Adicionado com sucesso !");
                        }
                    }
                });
        }
    }

    private void salvar() {
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturar();
            }
        });
    }
}
