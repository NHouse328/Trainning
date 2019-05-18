package com.trainning.todo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class BaseFragment extends Fragment {

    public void showAlert(String titulo, String mensagem) {
        new AlertDialog.Builder(getContext())
                .setTitle(titulo)
                .setMessage(mensagem)
                .setPositiveButton("Ok", null)
                .create().show();
    }

    public void showToast(String mensagem) {
        Toast.makeText(getContext(),mensagem,Toast.LENGTH_LONG).show();
    }

}
