package com.example.milestoneapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {


    EditText name;
    EditText apellido;
    EditText email;
    EditText password ;

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



    }
}
