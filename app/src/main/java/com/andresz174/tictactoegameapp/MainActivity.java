package com.andresz174.tictactoegameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    private LinearLayout jugadorUnoLayout, jugadorDosLayout;
    private TextView jugadorUnoNombre, jugadorDosNombre;

    private  ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugadorUnoNombre = findViewById(R.id.jugadorUnoNombre);
        jugadorDosNombre = findViewById(R.id.jugadorDosNombre);

        jugadorUnoLayout = findViewById(R.id.jugadorUnoLayout);
        jugadorDosLayout = findViewById(R.id.jugadorDosLayout);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);


        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});

        final String getJugadorUnoNombre = getIntent().getStringExtra("jugadorUno");
        final String getJugadorDosNombre = getIntent().getStringExtra("jugadorDos");

        jugadorUnoNombre.setText(getJugadorUnoNombre);
        jugadorDosNombre.setText(getJugadorDosNombre);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(0)){
                    performAction((ImageView)view, 0 );
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(1)){
                    performAction((ImageView)view, 1 );
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(2)){
                    performAction((ImageView)view, 2 );
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(3)){
                    performAction((ImageView)view, 3 );
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(4)){
                    performAction((ImageView)view, 4 );
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(5)){
                    performAction((ImageView)view, 5 );
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(6)){
                    performAction((ImageView)view, 6 );
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(7)){
                    performAction((ImageView)view, 7 );
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelectable(8)){
                    performAction((ImageView)view, 8 );
                }
            }
        });

        /*jugadorUnoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        jugadorDosLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/





    }

    private void performAction(ImageView imageView, int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = playerTurn;

        if (playerTurn == 1){
            imageView.setImageResource(R.drawable.x);

            if (checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this, jugadorUnoNombre.getText().toString() + " " +"ganó la partida.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if (totalSelectedBoxes == 9){
                WinDialog winDialog = new WinDialog(MainActivity.this, "Es un empate.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }

        }
        else {
            imageView.setImageResource(R.drawable.zero);
            if (checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this, jugadorDosNombre.getText().toString() + " " + "ganó la partida.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (selectedBoxPosition == 9) {
                WinDialog winDialog = new WinDialog(MainActivity.this, "Es un empate.", MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }

    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;

        if (playerTurn == 1){
            jugadorUnoLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            jugadorDosLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        } else {
            jugadorDosLayout.setBackgroundResource(R.drawable.round_back_blue_border);
            jugadorUnoLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }

    }

    private boolean checkPlayerWin(){
        boolean responde = false;

        for (int i = 0; i < combinationList.size(); i++){

            final int [] combination = combinationList.get(i);

            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn){
                responde = true;
            }

        }

        return responde;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if (boxPositions[boxPosition] == 0){
            response = true;
        }
        return response;
    }

    public void restartMatch () {
        boxPositions = new int []{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBoxes = 1;

        image1.setImageResource(R.drawable.transparente);
        image2.setImageResource(R.drawable.transparente);
        image3.setImageResource(R.drawable.transparente);
        image4.setImageResource(R.drawable.transparente);
        image5.setImageResource(R.drawable.transparente);
        image6.setImageResource(R.drawable.transparente);
        image7.setImageResource(R.drawable.transparente);
        image8.setImageResource(R.drawable.transparente);
        image9.setImageResource(R.drawable.transparente);
    }


}