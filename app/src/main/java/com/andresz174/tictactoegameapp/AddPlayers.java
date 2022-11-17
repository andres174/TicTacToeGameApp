package com.andresz174.tictactoegameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText jugadorUno = findViewById(R.id.jugadorUnoNombre);
        final EditText jugadorDos = findViewById((R.id.jugadorDosNombre));
    }
}