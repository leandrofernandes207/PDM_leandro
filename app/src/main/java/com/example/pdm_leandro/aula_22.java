package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class aula_22 extends AppCompatActivity {
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_22);
        res = (TextView) findViewById(R.id.resultado);
        Double et = getIntent().getDoubleExtra("celcius",1);
        res.setText(Double.toString(et));
    }
    public void totela2(View view){
        Intent intent = new Intent (this, aula_21.class);
        startActivity(intent);
    }

    public void toMenu(View view) {
        Intent intent = new Intent (this, menu.class);
        startActivity(intent);
    }
}
