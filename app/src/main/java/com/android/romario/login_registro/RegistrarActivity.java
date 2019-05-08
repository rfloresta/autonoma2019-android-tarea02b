package com.android.romario.login_registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrarActivity extends AppCompatActivity {

    ListView lvlProfesores;
    Button btnGrabar, btnSalir;
    EditText etNom;
    EditText etApe;
    ArrayList profesores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btnGrabar= (Button) findViewById(R.id.btnGrabar);
        btnSalir= (Button) findViewById(R.id.btnSalir);
        etNom= (EditText) findViewById(R.id.etNom);
        etApe= (EditText) findViewById(R.id.etApe);
        lvlProfesores= (ListView) findViewById(R.id.lvlProfesores);

        profesores=new ArrayList<String>();
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,profesores);
        lvlProfesores.setAdapter(adapter);

        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etNom.getText().toString().trim().isEmpty()) {
                    Toast.makeText(RegistrarActivity.this, "Ingrese Nombres, por favor!!", Toast.LENGTH_LONG).show();
                    etNom.requestFocus();
                    return;
                }
                if (etApe.getText().toString().trim().isEmpty()) {
                    Toast.makeText(RegistrarActivity.this, "Ingrese Apellidos, por favor!!", Toast.LENGTH_LONG).show();
                    etApe.requestFocus();
                    return;
                }
                    String nombre=etNom.getText().toString();
                    String apellido=etApe.getText().toString();
                    profesores.add(nombre+" "+apellido);
                    lvlProfesores.deferNotifyDataSetChanged();

                    //Limpiando texto
                    etNom.setText("");
                    etApe.setText("");
                    //Foco de texto
                    etNom.requestFocus();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistrarActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
