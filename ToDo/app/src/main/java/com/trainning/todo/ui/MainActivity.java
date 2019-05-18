package com.trainning.todo.ui;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.trainning.todo.BaseActivity;
import com.trainning.todo.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToFragment(new TarefasFragment(), 'a');

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    goToFragment(new TarefasFragment(), 'r');
                    return true;
                case R.id.navigation_add_tarefa:
                    goToFragment(new CadastroTarefaFragment(), 'r');
                    return true;
                case R.id.navigation_perfil:
                    goToFragment(new PerfilFragment(), 'r');
                    return true;
            }
            return false;
        }
    };

}
