package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class aula_34 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_34);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("gray")));
        setTitle(getResources().getText(R.string.Balaio));
        setTitleColor(000000);
    }
}
