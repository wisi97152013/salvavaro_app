package com.example.milestoneapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.http.RegisterHttpCallback;
import com.example.http.RegisterHttpClient;

public class RegisterActivity extends AppCompatActivity {


    EditText name;
    EditText apellido;
    EditText email;
    EditText password;

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        apellido = findViewById(R.id.apellido);
        password = findViewById(R.id.password);
        email = findViewById(R.id.correo);

        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.this.onRegisteredClicked();
            }
        });


    }

    private void onRegisteredClicked() {
        RegisterHttpClient.INSTANCE.registrarUsuario(new RegisterHttpCallback() {
            @Override
            public void onSuccess() {
                runOnUiThread(() -> showErrorDialog("BIEEEN"));

            }

            @Override
            public void onError() {
                runOnUiThread(() -> showErrorDialog("MAL"));

            }
        });


    }

    private void showErrorDialog(String err) {
        new AlertDialog.Builder(this)
                .setTitle("Login Failed")
                .setMessage(err)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
