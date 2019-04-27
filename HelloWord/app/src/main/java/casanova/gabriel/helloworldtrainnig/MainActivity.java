package casanova.gabriel.helloworldtrainnig;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vincular os componentes
        final   TextView    txv_result      = findViewById(R.id.txv_result  );
                Button      btn_run         = findViewById(R.id.btn_run     );
        //Fim Vincular os componentes

        //Evento do botão
        btn_run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txv_result.getText().toString().equals("Hello World!")) {
                    txv_result.setText(getString(R.string.text_ola));
                } else {
                    txv_result.setText(getString(R.string.text_hello));
                }
            }
        });
        //Fim Evento do botão
    }
}
