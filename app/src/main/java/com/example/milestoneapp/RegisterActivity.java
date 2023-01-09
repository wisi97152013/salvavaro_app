package com.example.milestoneapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.http.RegisterHttpCallback;
import com.example.http.RegisterHttpClient;
import com.example.model.Usuario;

public class RegisterActivity extends AppCompatActivity {


    EditText name;

    EditText email;
    EditText password;

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.correo);



        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario user=new Usuario(name.getText().toString(), password.getText().toString(), email.getText().toString());
                RegisterActivity.this.onRegisteredClicked(user);
            }
        });


    }

    private void onRegisteredClicked( Usuario user) {


        RegisterHttpClient.INSTANCE.registrarUsuario(new RegisterHttpCallback() {
            @Override
            public void onSuccess() {
                runOnUiThread(() -> showErrorDialog("Registro exitoso", "El usuario se ha creado exitosamente"));

            }

            @Override
            public void onError() {
                runOnUiThread(() -> showErrorDialog("Registro fallido", "Revisar los campos"));

            }
        }, user);


    }

    private void showErrorDialog(String titulo, String mensaje) {
        new AlertDialog.Builder(this)
                .setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
