package com.trainning.todo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity {

    public void showAlert(String titulo, String mensagem) {
        new AlertDialog.Builder(this)
                .setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton("Ok", null)
                .create().show();
    }

    public void showToast(String mensagem) {
        Toast.makeText(this,mensagem,Toast.LENGTH_LONG).show();
    }

    public void goToFragment(Fragment fragment, char action) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (action == 'a') {
            transaction.add(R.id.lnl_container,fragment); //transaction.add(R.id.lnl_container,fragment, "tag");
        } else {
            transaction.addToBackStack(null);
            transaction.replace(R.id.lnl_container,fragment);
        }
        transaction.commit();
    }
}
