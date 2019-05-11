package com.trainning.consultacep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView txv_resultado = findViewById(R.id.txv_resultado);

        SharedPreferences preferences = getSharedPreferences("CEP",MODE_PRIVATE);

        String CEP          = preferences.getString("CEP"           ,"ERROR 404!");
        String logradouro   = preferences.getString("logradouro"    ,"ERROR 404!");
        String numero       = preferences.getString("numero"        ,"ERROR 404!");
        String complemento  = preferences.getString("complemento"   ,"");
        String bairro       = preferences.getString("bairro"        ,"ERROR 404!");
        String cidade       = preferences.getString("cidade"        ,"ERROR 404!");
        String estado       = preferences.getString("estado"        ,"ERROR 404!");

        txv_resultado.setText(
                "CEP: "         + CEP           + "\n" +
                "Logradouro: "  + logradouro    + "\n" +
                "Número: "      + numero        + "\n" +
                "Complemento: " + complemento   + "\n" +
                "Bairro: "      + bairro        + "\n" +
                "Cidade: "      + cidade        + "\n" +
                "Estado: "      + estado

        );
    }
}
