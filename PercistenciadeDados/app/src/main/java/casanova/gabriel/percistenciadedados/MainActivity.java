package casanova.gabriel.percistenciadedados;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button      btn_entrar,btn_cadastrar;
    private EditText    edt_email ,edt_senha;

    private Context     context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vincular();
    }

    private void vincular() {
        edt_email         = findViewById(R.id.edt_email_login     );
        edt_senha         = findViewById(R.id.edt_senha_login     );
        btn_entrar        = findViewById(R.id.btn_entrar          );
        btn_cadastrar     = findViewById(R.id.btn_cadastrar_login );

        btn_entrar      .setOnClickListener(this);
        btn_cadastrar   .setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_entrar            : entrar()      ;break;
            case R.id.btn_cadastrar_login   : cadastrar()   ;break;
        }
    }

    private void cadastrar() {

        String email = edt_email.getEditableText().toString().trim().toLowerCase();

        //Objeto de trasporte
//        Bundle bundle = new Bundle();
//        bundle.putString(Constantes.EMAIL, email);

        Intent intent = new Intent(context,CadastroActivity.class);
        intent.putExtra(Constantes.EMAIL,email);
//        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void entrar() {

    }
}
