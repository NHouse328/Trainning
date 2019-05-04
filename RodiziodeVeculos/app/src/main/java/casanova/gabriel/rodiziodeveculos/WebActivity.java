package casanova.gabriel.rodiziodeveculos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        WebView webView = findViewById(R.id.wbv_mapa);


        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://www.google.com/maps/d/viewer?mid=1Xg6ACUNSiuS0IOr7p7t9c6IvLx4&msa=0&ll=-23.56894967405638%2C-46.660604999999975&z=12");


    }
}
