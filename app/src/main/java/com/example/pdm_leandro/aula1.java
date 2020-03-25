package com.example.pdm_leandro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class aula1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("message","on Create");
        setContentView(R.layout.activity_aula1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message","on Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message","on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message","on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message","on Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("message","on Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message","on Destroy");
    }

    public void toMenu(View view) {
        Intent intent = new Intent (this, menu.class);
        startActivity(intent);
    }
}
