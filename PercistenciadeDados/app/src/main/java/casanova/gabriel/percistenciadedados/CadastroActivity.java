package casanova.gabriel.percistenciadedados;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText    edt_email,edt_nome,edt_senha;
    private Button      btn_criar;

    private Context     context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        vincular();

        recuperandoBundle();

        btn_criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edt_nome.getEditableText().toString().trim();
                String email = edt_email.getEditableText().toString().trim().toLowerCase();
                String senha = edt_senha.getEditableText().toString().trim();

                Intent intent = new Intent(context,ResultadoActivity.class);

                intent.putExtra(Constantes.NOME,nome);
                intent.putExtra(Constantes.EMAIL,email);
                intent.putExtra(Constantes.SENHA,senha);

                startActivity(intent);

            }
        });

    }

    private void vincular() {
        edt_nome    = findViewById(R.id.edt_nome_cadastrar  );
        edt_email   = findViewById(R.id.edt_email_cadastrar );
        edt_senha   = findViewById(R.id.edt_senha_cadastrar );
        btn_criar   = findViewById(R.id.btn_criar           );
    }

    private void recuperandoBundle() {
//        Bundle bundle = getIntent().getExtras();
//        String email = bundle != null ? bundle.getString(Constantes.EMAIL) : null;

        String email = getIntent().getStringExtra(Constantes.EMAIL);

        edt_email.setText(email);
    }
}
