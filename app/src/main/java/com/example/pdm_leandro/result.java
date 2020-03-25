package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        res = (TextView) findViewById(R.id.resultado);
        Double et = getIntent().getDoubleExtra("celcius",1);
        res.setText(Double.toString(et));
    }
    public void totela2(View view){
        Intent intent = new Intent (this, tela2.class);
        startActivity(intent);
    }

    public void toMenu(View view) {
        Intent intent = new Intent (this, menu.class);
        startActivity(intent);
    }
}
