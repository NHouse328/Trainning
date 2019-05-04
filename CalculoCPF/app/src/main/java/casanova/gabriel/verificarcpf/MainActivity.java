package casanova.gabriel.verificarcpf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declarando componentes
    private EditText  edt_cpf;
    private ImageView img_cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_cpf = findViewById(R.id.edt_cpf);
        img_cpf = findViewById(R.id.img_cpf);
    }

    public void onVerificar(View view) {
        String cpf = edt_cpf.getEditableText().toString().trim();

        if (cpf.length() != 11) {
            Toast.makeText(this,"Digite um CPF com 11 números",Toast.LENGTH_LONG).show();
        } else {
            Calculos calculos = new Calculos();
            if (calculos.verificar(cpf)) {
                img_cpf.setImageResource (R.drawable.ic_thumb_up);
            } else {
                img_cpf.setImageResource (R.drawable.ic_thumb_down);
            }
        }
    }


}
