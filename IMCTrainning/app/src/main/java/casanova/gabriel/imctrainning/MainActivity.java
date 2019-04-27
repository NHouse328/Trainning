package casanova.gabriel.imctrainning;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText    edt_altura, edt_peso ;
    private TextView    txv_resultado   ;
    private Button      btn_calcular    ;
    private ImageView   img_resultado   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv_resultado   = findViewById(R.id.txv_result      );
        edt_altura      = findViewById(R.id.edt_altura      );
        edt_peso        = findViewById(R.id.edt_peso        );
        btn_calcular    = findViewById(R.id.btn_calcular    );
        img_resultado   = findViewById(R.id.img_result      );

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String peso = edt_peso.getEditableText().toString().trim();
                String altura = edt_altura.getEditableText().toString().trim();

                if (!peso.isEmpty() && !altura.isEmpty()) {

                    Double pesoD = Double.parseDouble(peso);
                    Double alturaD = Double.parseDouble(altura);

                    double imc = pesoD / (alturaD * alturaD);

                    String mensagem;
                    Drawable foto;

                    if (imc < 18.5) {
                        mensagem = "Magreza";
                        foto = getDrawable(R.drawable.magreza);
                    } else if (imc < 24.9) {
                        mensagem = "Saudável";
                        foto = getDrawable(R.drawable.abaixo);
                    } else if (imc < 29.9) {
                        mensagem = "Sobrepeso";
                        foto = getDrawable(R.drawable.ideal);
                    } else if (imc < 34.9) {
                        mensagem = "Obesidade Grau I";
                        foto = getDrawable(R.drawable.sobre);
                    } else if (imc < 39.9) {
                        mensagem = "Obesidade Grau II";
                        foto = getDrawable(R.drawable.obesidade);
                    } else {
                        mensagem = "Obesidade Grau III";
                        foto = getDrawable(R.drawable.obesidade);
                    }

                    txv_resultado.setText(mensagem);
                    img_resultado.setImageDrawable(foto);
                }
            }
        });

    }

}
