package com.example.manzanaverde;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText textUsuario;
    EditText textPassword;

    Button buttonRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUsuario = (EditText) findViewById(R.id.txtUsuario);
        textPassword = (EditText) findViewById(R.id.txtContrasena);

        buttonRegistro = (Button) findViewById(R.id.btnSesion);

        buttonRegistro.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Check();
            }
        });

        Button buttonFacebook = (Button) findViewById(R.id.btnFacebook);
        buttonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://es-la.facebook.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button buttonGoogle = (Button) findViewById(R.id.btnGoogle);
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://accounts.google.com/signin/v2/identifier?hl=es&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    public void Check(){
        if (textUsuario.getText().toString().equals("ejemplo@correo.com") && textPassword.getText().toString().equals("123456")) {
            Intent myIntent = new Intent(MainActivity.this, WelcomeMessage.class);
            MainActivity.this.startActivity(myIntent);
        }else {
            Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_LONG).show();
        }
    }
}