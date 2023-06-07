package com.example.magicsquare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class game4x4 extends AppCompatActivity {
    private TextView num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15, num16;
    private EditText WriteNum1, WriteNum2, WriteNum3, WriteNum4, WriteNum5, WriteNum6, WriteNum7, WriteNum8, WriteNum9, WriteNum10, WriteNum11, WriteNum12, WriteNum13, WriteNum14, WriteNum15, WriteNum16;
    private TextView text3, rightwrong;
    private Button btnGuess2, btnCheck2;
    public void gen_matrix() {
        
        int summa = (int) (Math.random() * 16 + 1) + 20;
        String g = summa + "";
        text3.setText(g);
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, c11 = 0, c12 = 0, c13 = 0, c14 = 0, c15 =0, c16 = 0;
        //вторая строка
        c6=(int) (Math.random() * (9) + 1);
        c7=(int) (Math.random() * (9) + 1);
        c5=(int) (Math.random() * ((summa-c6-c7)) + 1);
        c8=summa-c5-c6-c7;
        //третья строка
        c10=(int) (Math.random() * (9) + 1);
        c11=(int) (Math.random() * (9) + 1);
        c9=(int) (Math.random() * ((summa-c10-c11)) + 1);
        c12=summa-c10-c11-c9;
        //второй столбец
        c2=(int) (Math.random() * ((summa-c6-c10)) + 1);
        c14=summa-c6-c10-c2;
        //третий столбец
        c3=(int) (Math.random() * ((summa-c7-c11)) + 1);
        c15=summa-c7-c11-c3;
        //одна диагональ
        c1=(int) (Math.random() * ((summa-c6-c11)) + 1);
        c16=summa-c11-c6-c1;
        //другая диагональ
        c4=(int) (Math.random() * ((summa-c10-c7)) + 1);
        c13=summa-c10-c4-c7;

        String mes1 = c1 + "", mes2 = c2 + "", mes3 = c3 + "", mes4 = c4 + "";
        String mes5 = c5 + "", mes6 = c6 + "", mes7 = c7 + "", mes8 = c8 + "";
        String mes9 = c9 + "", mes10 = c10 + "", mes11 = c11 + "", mes12 = c12 + "";
        String mes13 = c13 + "", mes14 = c14 + "", mes15 = c15 + "", mes16 = c16 + "";
        num1.setText(mes1);num2.setText(mes2);num3.setText(mes3);num4.setText(mes4);
        num5.setText(mes5);num6.setText(mes6);num7.setText(mes7);num8.setText(mes8);
        num9.setText(mes9);num10.setText(mes10);num11.setText(mes11);num12.setText(mes12);
        num13.setText(mes13);num14.setText(mes14);num15.setText(mes15);num16.setText(mes16);
    }
    public void gen_game() {
        TextView[] a = {num1, num2, num3, num4, num5, num8, num9, num12, num13, num14, num15, num16};
        EditText[] b = {WriteNum1, WriteNum2, WriteNum3, WriteNum4, WriteNum5, WriteNum8, WriteNum9, WriteNum12, WriteNum13, WriteNum14, WriteNum15, WriteNum16};

        for (int i = 0; i < 11; i++) {
            a[i].setVisibility(View.VISIBLE);
            b[i].setVisibility(View.INVISIBLE);
        }
        TextView[] a2 = {num6, num7, num10, num11};
        EditText[] b2 = {WriteNum6, WriteNum7, WriteNum10, WriteNum11};
        for (int i = 0; i < 3; i++) {
            a2[i].setVisibility(View.VISIBLE);
            b2[i].setVisibility(View.INVISIBLE);
        }

        for (int i = 0; i < 9; i++) {
            int change = (int) (Math.random() * 12);
            while (a[change].getVisibility() == View.INVISIBLE)
                change = (int) (Math.random() * 12);
            a[change].setVisibility(View.INVISIBLE);
            b[change].setVisibility(View.VISIBLE);
        }
        for (int i = 0; i < 1; i++) {
            int change = (int) (Math.random() * 4);
            while (a2[change].getVisibility() == View.INVISIBLE)
                change = (int) (Math.random() * 4);
            a2[change].setVisibility(View.INVISIBLE);
            b2[change].setVisibility(View.VISIBLE);
        }

    }
    public boolean checking_the_result() {
        TextView[] a = {num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15, num16};
        EditText[] b = {WriteNum1, WriteNum2, WriteNum3, WriteNum4, WriteNum5, WriteNum6, WriteNum7, WriteNum8, WriteNum9, WriteNum10, WriteNum11, WriteNum12, WriteNum13, WriteNum14, WriteNum15, WriteNum16};
        int[] cell = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < 16; i++) {
            if (a[i].getVisibility() == View.VISIBLE) {
                String guessText = a[i].getText().toString();
                cell[i] = Integer.parseInt(guessText);
            } else {
                String guessText = b[i].getText().toString();
                cell[i] = Integer.parseInt(guessText);
            }
        }
        String guessText = text3.getText().toString();
        int summa = Integer.parseInt(guessText);
        if (cell[0] + cell[5] + cell[10] + cell[15] == summa)
            if (cell[1] + cell[5] + cell[9] + cell[13] == summa)
                if (cell[3] + cell[6] + cell[9] + cell[12] == summa)
                    if (cell[2] + cell[6] + cell[10] + cell[14] == summa)
                        if (cell[4] + cell[5] + cell[6] + cell[7] == summa)
                            if (cell[8] + cell[9] + cell[10] + cell[11] == summa) {
                                return true;
                            }
        return false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4x4);
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        num3 = (TextView) findViewById(R.id.num3);
        num4 = (TextView) findViewById(R.id.num4);
        num5 = (TextView) findViewById(R.id.num5);
        num6 = (TextView) findViewById(R.id.num6);
        num7 = (TextView) findViewById(R.id.num7);
        num8 = (TextView) findViewById(R.id.num8);
        num9 = (TextView) findViewById(R.id.num9);
        num10 = (TextView) findViewById(R.id.num10);
        num11 = (TextView) findViewById(R.id.num11);
        num12 = (TextView) findViewById(R.id.num12);
        num13 = (TextView) findViewById(R.id.num13);
        num14 = (TextView) findViewById(R.id.num14);
        num15 = (TextView) findViewById(R.id.num15);
        num16 = (TextView) findViewById(R.id.num16);
        WriteNum1 = (EditText) findViewById(R.id.WriteNum1);
        WriteNum2 = (EditText) findViewById(R.id.WriteNum2);
        WriteNum3 = (EditText) findViewById(R.id.WriteNum3);
        WriteNum4 = (EditText) findViewById(R.id.WriteNum4);
        WriteNum5 = (EditText) findViewById(R.id.WriteNum5);
        WriteNum6 = (EditText) findViewById(R.id.WriteNum6);
        WriteNum7 = (EditText) findViewById(R.id.WriteNum7);
        WriteNum8 = (EditText) findViewById(R.id.WriteNum8);
        WriteNum9 = (EditText) findViewById(R.id.WriteNum9);
        WriteNum10 = (EditText) findViewById(R.id.WriteNum10);
        WriteNum11 = (EditText) findViewById(R.id.WriteNum11);
        WriteNum12 = (EditText) findViewById(R.id.WriteNum12);
        WriteNum13 = (EditText) findViewById(R.id.WriteNum13);
        WriteNum14 = (EditText) findViewById(R.id.WriteNum14);
        WriteNum15 = (EditText) findViewById(R.id.WriteNum15);
        WriteNum16 = (EditText) findViewById(R.id.WriteNum16);
        text3 = (TextView) findViewById(R.id.text3);
        rightwrong = (TextView) findViewById(R.id.rightwrong);
        btnGuess2 = (Button) findViewById(R.id.btnGuess2);
        btnCheck2 = (Button) findViewById(R.id.btnCheck2);

        btnGuess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gen_matrix();
                gen_game();
            }
        });
        btnCheck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = "Это магический квадрат";
                String w = "Это не магический квадрат";
                if (checking_the_result() == true) {
                    rightwrong.setText(r);
                    rightwrong.setVisibility(View.VISIBLE);
                } else {
                    rightwrong.setText(w);
                    rightwrong.setVisibility(View.VISIBLE);
                }

            }

        });
    }
    public void back4x4(View v) {
        Intent intent3 = new Intent(this, GameSelection.class);
        startActivity(intent3);
    }
}