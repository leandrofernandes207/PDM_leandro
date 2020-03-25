package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class aula_33 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_33);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.quiz_transito_icon);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("black")));
        setTitle(getResources().getText(R.string.Quiz_de_trânsito));
    }
}
