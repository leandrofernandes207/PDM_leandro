package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

    }
    public void totela1(View view){
        Intent intent = new Intent (this, aula1.class);
        startActivity(intent);
    }
    public void Calc(View v) {
        Intent intent = new Intent (this, result.class);
        EditText et = (EditText) findViewById(R.id.fahren);
        double fahr = (Double.parseDouble(et.getText().toString()) * 9 / 5) + 32;
        intent.putExtra("celcius",fahr);
        startActivity(intent);
    }
}
