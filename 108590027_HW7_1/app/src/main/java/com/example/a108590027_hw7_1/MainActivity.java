package com.example.a108590027_hw7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void donut_click(View view){
        Intent intent = new Intent(this, DonutActivity.class);
        startActivity(intent);
    }

    public void froyo_click(View view){
        Intent intent = new Intent(this, FroyoActivity.class);
        startActivity(intent);
    }

    public void ice_click(View view){
        Intent intent = new Intent(this, IceActivity.class);
        startActivity(intent);
    }
}