package com.trainning.todo.ui;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.trainning.todo.BaseFragment;
import com.trainning.todo.R;
import com.trainning.todo.model.Constantes;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends BaseFragment implements View.OnClickListener {

    //Declarar
    private View            rootView    ;
    private TextView        txv_nome    ,
                            txv_email   ,
                            txv_telefone;
    private ImageView       imv_perfil  ;
    private FirebaseAuth    user        ;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_perfil, container, false);

        bindView(rootView);

        getProfile();

        return rootView;
    }

    private void bindView(View rootView) {
        txv_nome        = rootView.findViewById(R.id.txv_nome       );
        txv_email       = rootView.findViewById(R.id.txv_email      );
        imv_perfil      = rootView.findViewById(R.id.imv_perfil     );
        txv_telefone    = rootView.findViewById(R.id.txv_telefone   );

        rootView.findViewById(R.id.btn_sair     ).setOnClickListener(this);
        rootView.findViewById(R.id.btn_excluir  ).setOnClickListener(this);
        rootView.findViewById(R.id.ibt_camera   ).setOnClickListener(this);
        rootView.findViewById(R.id.ibt_editar   ).setOnClickListener(this);

        user = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sair      : sair()    ;break;
            case R.id.btn_excluir   : excluir() ;break;
            case R.id.ibt_camera    : camera()  ;break;
            case R.id.ibt_editar    : editar()  ;break;
        }
    }

    private void getProfile(){
        FirebaseUser firebaseUser = user.getCurrentUser();
        if (firebaseUser != null) {
            txv_nome.setText    (firebaseUser.getDisplayName    ());
            txv_email.setText   (firebaseUser.getEmail          ());
            txv_telefone.setText(firebaseUser.getPhoneNumber    ());
        } else {
            showAlert("Algo deu errado","Falha de comunicação com o servidor, se vira ai que não tenho o que fazer");
        }
    }

    private void editar() {
        showToast("Fazer metodo para editar Perfil");
        FirebaseAuth.getInstance().getCurrentUser();//TODO//Fazer metodo para editar Perfil
    }

    private void camera() {
        startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), Constantes.FOTO);
    }

    private void excluir() {
        user.getCurrentUser().delete();
        toSplash();
    }

    private void sair() {
        //user.signOut();
        getActivity().finishAndRemoveTask(); // fecha o app inteiro
    }

    private void toSplash() {
        startActivity(new Intent(getContext(),SplashActivity.class));
        getActivity().finishAffinity(); //Finaliza todas as Activitys menos a que vai
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        getActivity();
        if (requestCode == Constantes.FOTO && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imv_perfil.setImageBitmap(bitmap);

            //TODO//Salvar essa foto no Firebase Storage
        } else {
            showAlert("Falha","Deu erro ai !, tenta de novo e se não resolver se vira ai.");
        }
    }
}
