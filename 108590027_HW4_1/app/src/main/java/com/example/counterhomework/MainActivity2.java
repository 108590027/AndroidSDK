package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        TextView textBox = (TextView) findViewById(R.id.text_header);
        String recmsg = textBox.getText().toString() + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textBox.setText(recmsg);
    }
}