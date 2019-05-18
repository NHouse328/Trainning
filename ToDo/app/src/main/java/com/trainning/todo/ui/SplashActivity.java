package com.trainning.todo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.trainning.todo.BaseActivity;
import com.trainning.todo.model.Constantes;

import java.util.Arrays;
import java.util.List;

public class SplashActivity extends BaseActivity {

    private Handler handler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindView();
        userLogged();
    }

    private void userLogged() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            goToLogin();
        } else {
            user.getIdToken(true)
                    .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                        @Override
                        public void onComplete(@NonNull Task<GetTokenResult> task) {
                            if (task.isSuccessful()) {
                                goToMain();
                            } else {
                                String msn = task.getException().getMessage();
                                showToast(msn);

                                goToLogin();
                            }
                            finish();
                        }
                    });
        }
    }

    private void bindView() {
        handler = new Handler();
    }

    private void goToMain() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 1000);
    }

    private void goToLogin() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Criar lista de providers
                List<AuthUI.IdpConfig> providers = Arrays.asList(
                        new AuthUI.IdpConfig.EmailBuilder().build(),
                        new AuthUI.IdpConfig.PhoneBuilder().build(),
                        new AuthUI.IdpConfig.GoogleBuilder().build()
                );

                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setAvailableProviders(providers)
                                .build(),
                        Constantes.SIGN_IN
                );
            }
        }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constantes.SIGN_IN && resultCode == RESULT_OK) {
            goToMain();
        }
    }
}
