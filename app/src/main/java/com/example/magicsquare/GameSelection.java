package com.example.magicsquare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameSelection extends AppCompatActivity {


    private EditText txtGuess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);


    }

    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void G3x3(View v) {
        Intent intent2 = new Intent(this, Game3x3.class);
        startActivity(intent2);
    }

    public void G4x4(View v) {
        Intent intent3 = new Intent(this, game4x4.class);
        startActivity(intent3);
    }
}