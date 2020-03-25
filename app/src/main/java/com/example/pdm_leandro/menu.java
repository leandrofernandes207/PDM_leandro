package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void totela1(View view){
        Intent intent = new Intent (this, aula1.class);
        startActivity(intent);
    }

    public void totela2(View view){
        Intent intent = new Intent (this, tela2.class);
        startActivity(intent);
    }
    public void toAula31(View view){
        Intent intent = new Intent (this, aula_31.class);
        startActivity(intent);
    }
    public void toAula32(View view){
        Intent intent = new Intent (this, aula_32.class);
        startActivity(intent);
    }
    public void toAula33(View view){
        Intent intent = new Intent (this, aula_33.class);
        startActivity(intent);
    }
    public void toAula34(View view){
        Intent intent = new Intent (this, aula_34.class);
        startActivity(intent);
    }

}
