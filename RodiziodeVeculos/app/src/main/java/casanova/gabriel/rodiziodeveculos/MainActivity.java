package casanova.gabriel.rodiziodeveculos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Implementa para varios botoes
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText    edt_placa;
    private Button      btn_mapa, btn_verificar;
    private Context     context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vincular();

    }

    private void vincular() {
        edt_placa       = findViewById(R.id.edt_placa       );
        btn_mapa        = findViewById(R.id.btn_mapa        );
        btn_verificar   = findViewById(R.id.btn_verificar   );

        btn_mapa        .setOnClickListener(this);
        btn_verificar   .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_verificar : verificar()   ;break;
            case R.id.btn_mapa      : mapa()        ;break;
        }
    }

    private void mapa() {
        //Classe objeto = new Método construtor
        Intent intent = new Intent(context,WebActivity.class);
        startActivity(intent);
    }

    private void verificar() {
        //Recuperado a placa
        String placa = edt_placa.getEditableText().toString().trim().toUpperCase();
        //regex
        String regex = "[A-Z]{3}\\d{4}";

        //Validando Placa
        if (!placa.matches(regex)) {
            //Toast
            Toast.makeText(context,"Não é uma placa valida",Toast.LENGTH_LONG).show();
        } else {
            //Capturar o digito da placa
            char digito = placa.charAt(6);

            String mensagem = "A placa " + placa + ". Tem o Rodízio na ";

            switch (digito) {
                case '1':
                case '2': mensagem += "Segunda-Feira"   ;break;
                case '3':
                case '4': mensagem += "Terça-Feira"     ;break;
                case '5':
                case '6': mensagem += "Quarta-Feira"    ;break;
                case '7':
                case '8': mensagem += "Quinta-Feira"    ;break;
                case '9':
                case '0': mensagem += "Sexta-Feira"     ;break;
            }

//            Toast.makeText(context,mensagem,Toast.LENGTH_LONG).show();

            //Alert criado
            new AlertDialog.Builder(context)
                    .setTitle("Atenção !")
                    .setMessage(mensagem)
                    .setPositiveButton("Ok !", null)
                    .setIcon(R.mipmap.ic_launcher_round)
                    .setCancelable(false)
                    .create().show();

        }
    }


}
