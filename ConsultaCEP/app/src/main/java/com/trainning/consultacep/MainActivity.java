package com.trainning.consultacep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edt_cep,edt_logradouro,edt_numero,edt_complemento,edt_bairro,edt_cidade,edt_estado;
    private Button btn_salvar;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vincular();

        pesquisaCEP();

        salvar();
    }

    private void vincular() {
        btn_salvar      = findViewById(R.id.btn_salvar      );
        edt_cep         = findViewById(R.id.edt_cep         );
        edt_logradouro  = findViewById(R.id.edt_logradouro  );
        edt_numero      = findViewById(R.id.edt_numero      );
        edt_complemento = findViewById(R.id.edt_complemento );
        edt_bairro      = findViewById(R.id.edt_bairro      );
        edt_cidade      = findViewById(R.id.edt_cidade      );
        edt_estado      = findViewById(R.id.edt_estado      );

        preferences     = getSharedPreferences("CEP",MODE_PRIVATE);
        editor          = preferences.edit();
    }

    private void pesquisaCEP() {
        edt_cep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable cep) {

                if (cep.toString().length() == 8) {
                    retrofit(cep.toString());
                }

            }
        });
    }

    private void retrofit(String cep) {
        Call<Endereco> enderecoCall = new RetrofitConfig().getCEP().buscarCEP(cep);

        enderecoCall.enqueue(new Callback<Endereco>() {
            @Override
            public void onResponse(Call<Endereco> call, Response<Endereco> response) {

                if( response.body() != null) {
                    Endereco endereco = response.body();

                    edt_logradouro.setText(endereco.getLogradouro());
                    edt_bairro.setText(endereco.getBairro());
                    edt_cidade.setText(endereco.getLocalidade());
                    edt_estado.setText(endereco.getUf());
                }
            }

            @Override
            public void onFailure(Call<Endereco> call, Throwable t) {

            }
        });
    }

    private void capturar() {
        String cep          = edt_cep           .getEditableText().toString().trim();
        String logradouro   = edt_logradouro    .getEditableText().toString().trim();
        String numero       = edt_numero        .getEditableText().toString().trim();
        String complemento  = edt_complemento   .getEditableText().toString().trim();
        String bairro       = edt_bairro        .getEditableText().toString().trim();
        String cidade       = edt_cidade        .getEditableText().toString().trim();
        String estado       = edt_estado        .getEditableText().toString().trim();

        if (numero.isEmpty()) {
            edt_numero.setError("Campo obrigatório!");
            edt_numero.requestFocus();
        } else {
            editor.putString("CEP",cep);
            editor.putString("logradouro",logradouro);
            editor.putString("numero",numero);
            editor.putString("complemento",complemento);
            editor.putString("bairro",bairro);
            editor.putString("cidade",cidade);
            editor.putString("estado",estado);

            editor.commit();

            startActivity(new Intent(MainActivity.this,ResultadoActivity.class));
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
