package casanova.gabriel.percistenciadedados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        TextView resultado = findViewById(R.id.txv_resultado);

        String nome = getIntent().getStringExtra(Constantes.NOME);
        String email = getIntent().getStringExtra(Constantes.EMAIL);
        String senha = getIntent().getStringExtra(Constantes.SENHA);

        resultado.setText("Nome: " + nome + "\nE-mail: " + email + "\nSenha: " + senha);
    }
}
