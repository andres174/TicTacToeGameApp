package com.andresz174.tictactoegameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<int[]> combinationList = new ArrayList<>();

    private int [] boxPositions = {0,0,0,0,0,0,0,0,0};

    private int playerTurn = 1;

    private int totalSelectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView jugadorUnoNombre = findViewById(R.id.jugadorUnoNombre);
        final TextView jugadorDosNombre = findViewById(R.id.jugadorDosNombre);

        final LinearLayout jugadorUnoLayout = findViewById(R.id.jugadorUnoLayout);
        final LinearLayout jugadorDosLayout = findViewById(R.id.jugadorDosLayout);

        final ImageView image1 = findViewById(R.id.image1);
        final ImageView image2 = findViewById(R.id.image2);
        final ImageView image3 = findViewById(R.id.image3);
        final ImageView image4 = findViewById(R.id.image4);
        final ImageView image5 = findViewById(R.id.image5);
        final ImageView image6 = findViewById(R.id.image6);
        final ImageView image7 = findViewById(R.id.image7);
        final ImageView image8 = findViewById(R.id.image8);
        final ImageView image9 = findViewById(R.id.image9);

        //min27





    }
}