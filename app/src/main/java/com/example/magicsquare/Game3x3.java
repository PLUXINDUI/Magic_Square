package com.example.magicsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Game3x3 extends AppCompatActivity {
    private TextView NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, NUM9, RIGHTWRONG;
    private EditText writeNum1, writeNum2, writeNum3, writeNum4, writeNum5, writeNum6, writeNum7, writeNum8, writeNum9;
    private TextView text;
    private Button btnGuess, btnCheck;
    private EditText txt_guess;

    public void gen_matrix() {
        int summa = (int) (Math.random() * 14 + 1) + 10;
        String g = summa + "";
        text.setText(g);
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0;
        //Первая диагональ
        c1 = (int) (Math.random() * (9) + 1);
        while (c3 == 0) {
            c9 = (int) (Math.random() * (9) + 1);
            while (summa - c1 - c9 < 0) {
                c9 = (int) (Math.random() * (9) + 1);
            }
            c5 = summa - c1 - c9;
            for (int i = 1; i < 9; i++) {
                c3 = i;
                c7 = summa - c5 - c3;
                if (c7 > 0 && c7 < 9)
                    break;
                c3 = 0;
            }
        }


        //Середины боковых граней
        c2 = summa - c1 - c3;
        c4 = summa - c1 - c7;
        c6 = summa - c3 - c9;
        c8 = summa - c7 - c9;

        String mes1 = c1 + "", mes2 = c2 + "", mes3 = c3 + "";
        String mes4 = c4 + "", mes5 = c5 + "", mes6 = c6 + "";
        String mes7 = c7 + "", mes8 = c8 + "", mes9 = c9 + "";
        NUM1.setText(mes1);
        NUM2.setText(mes2);
        NUM3.setText(mes3);
        NUM4.setText(mes4);
        NUM5.setText(mes5);
        NUM6.setText(mes6);
        NUM7.setText(mes7);
        NUM8.setText(mes8);
        NUM9.setText(mes9);
    }

    public void gen_game() {
        TextView[] a = {NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, NUM9};
        EditText[] b = {writeNum1, writeNum2, writeNum3, writeNum4, writeNum5, writeNum6, writeNum7, writeNum8, writeNum9};
        for (int i = 0; i < 9; i++) {
            a[i].setVisibility(View.VISIBLE);
            b[i].setVisibility(View.INVISIBLE);

        }
        for (int i = 0; i < 6; i++) {
            int change = (int) (Math.random() * 9);
            while (a[change].getVisibility() == View.INVISIBLE)
                change = (int) (Math.random() * 9);
            a[change].setVisibility(View.INVISIBLE);
            b[change].setVisibility(View.VISIBLE);
        }
    }

    public boolean checking_the_result() {
        TextView[] a = {NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, NUM9};
        EditText[] b = {writeNum1, writeNum2, writeNum3, writeNum4, writeNum5, writeNum6, writeNum7, writeNum8, writeNum9};
        int[] cell = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 9; i++) {
            if (a[i].getVisibility() == View.VISIBLE) {
                String guessText = a[i].getText().toString();
                cell[i] = Integer.parseInt(guessText);
            } else {
                String guessText = b[i].getText().toString();
                cell[i] = Integer.parseInt(guessText);
            }
        }


        String guessText = text.getText().toString();
        int summa = Integer.parseInt(guessText);
        if (cell[0] + cell[1] + cell[2] == summa)
            if (cell[0] + cell[3] + cell[6] == summa)
                if (cell[0] + cell[4] + cell[8] == summa)
                    if (cell[2] + cell[5] + cell[8] == summa)
                        if (cell[6] + cell[7] + cell[8] == summa)
                            if (cell[2] + cell[4] + cell[6] == summa) {
                                return true;
                            }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3x3);
        Log.d("Test321", "oncreate void");
        //text = (TextView) findViewById(R.id.text);
        NUM1 = (TextView) findViewById(R.id.NUM1);
        NUM2 = (TextView) findViewById(R.id.NUM2);
        NUM3 = (TextView) findViewById(R.id.NUM3);
        NUM4 = (TextView) findViewById(R.id.NUM4);
        NUM5 = (TextView) findViewById(R.id.NUM5);
        NUM6 = (TextView) findViewById(R.id.NUM6);
        NUM7 = (TextView) findViewById(R.id.NUM7);
        NUM8 = (TextView) findViewById(R.id.NUM8);
        NUM9 = (TextView) findViewById(R.id.NUM9);
        text = (TextView) findViewById(R.id.text);
        RIGHTWRONG = (TextView) findViewById(R.id.RIGHTWRONG);
        writeNum1 = (EditText) findViewById(R.id.writeNum1);
        writeNum2 = (EditText) findViewById(R.id.writeNum2);
        writeNum3 = (EditText) findViewById(R.id.writeNum3);
        writeNum4 = (EditText) findViewById(R.id.writeNum4);
        writeNum5 = (EditText) findViewById(R.id.writeNum5);
        writeNum6 = (EditText) findViewById(R.id.writeNum6);
        writeNum7 = (EditText) findViewById(R.id.writeNum7);
        writeNum8 = (EditText) findViewById(R.id.writeNum8);
        writeNum9 = (EditText) findViewById(R.id.writeNum9);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        btnCheck = (Button) findViewById(R.id.btnCheck);

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (true) {
                    gen_matrix();
                    String guessText = NUM2.getText().toString();
                    int x1 = Integer.parseInt(guessText);
                    guessText = NUM4.getText().toString();
                    int x2 = Integer.parseInt(guessText);
                    guessText = NUM6.getText().toString();
                    int x3 = Integer.parseInt(guessText);
                    guessText = NUM8.getText().toString();
                    int x4 = Integer.parseInt(guessText);
                    if (x1 > 0 && x2 > 0 && x3 > 0 && x4 > 0)
                        break;
                }
                gen_game();
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = "Это магический квадрат";
                String w = "Это не магический квадрат";
                if (checking_the_result() == true) {
                    RIGHTWRONG.setText(r);
                    RIGHTWRONG.setVisibility(View.VISIBLE);
                } else {
                    RIGHTWRONG.setText(w);
                    RIGHTWRONG.setVisibility(View.VISIBLE);
                }

            }


        });


    }

    public void back3x3(View v) {
        Intent intent3 = new Intent(this, GameSelection.class);
        startActivity(intent3);
    }
}