package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class aula_21 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_21);

    }

    public void Calc(View v) {
        Intent intent = new Intent (this, aula_22.class);
        EditText et = (EditText) findViewById(R.id.fahren);
        double fahr = (Double.parseDouble(et.getText().toString()) * 9 / 5) + 32;
        intent.putExtra("celcius",fahr);
        startActivity(intent);
    }

    public void toMenu(View view) {
        Intent intent = new Intent (this, menu.class);
        startActivity(intent);

    }
}
