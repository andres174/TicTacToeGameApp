package com.andresz174.tictactoegameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText jugadorUno = findViewById(R.id.jugadorUnoNombre);
        final EditText jugadorDos = findViewById(R.id.jugadorDosNombre);
        final Button startGameBtn = findViewById(R.id.startGameBtn);

        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getJugadorUnoNombre = jugadorUno.getText().toString();
                final String getJugadorDosNombre = jugadorDos.getText().toString();

                if (getJugadorUnoNombre.isEmpty() || getJugadorDosNombre.isEmpty()){
                    Toast.makeText(AddPlayers.this, "Ingrese los nombres de los jugadores.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("jugadorUno", getJugadorUnoNombre);
                    intent.putExtra("jugadorDos", getJugadorDosNombre);
                    startActivity(intent);

                }
            }
        });

        //10:50
    }
}