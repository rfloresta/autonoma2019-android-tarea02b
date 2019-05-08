package com.android.romario.login_registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

        Button btnIngresar, btnCerrar;
         EditText etUsu;
         EditText etClave;

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            btnIngresar = (Button) findViewById(R.id.btnIngresar);
            btnCerrar = (Button) findViewById(R.id.btnCerrar);
            etUsu = (EditText) findViewById(R.id.etUsu);
            etClave = (EditText) findViewById(R.id.etClave);

            btnIngresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (etUsu.getText().toString().trim().isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Ingrese el usuario, por favor!!", Toast.LENGTH_LONG).show();
                        etUsu.requestFocus();
                        return;
                    }
                    if (etClave.getText().toString().trim().isEmpty()) {
                        Toast.makeText(LoginActivity.this, "Ingrese la clave, por favor!!", Toast.LENGTH_LONG).show();
                        etClave.requestFocus();
                        return;
                    }
                    if (etUsu.getText().toString().equals("romario") && etClave.getText().toString().equals("1234")) {
                        Intent i = new Intent(LoginActivity.this, RegistrarActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(LoginActivity.this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                    }
                }
            });

            btnCerrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    Intent intent=new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
    }

