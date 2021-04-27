package com.example.a108590027_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int level = 4;
    private ImageView mImg;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImg = findViewById(R.id.imageView);
        mImg.setImageLevel(level);

        mText = findViewById(R.id.textView_level);
        mText.setText(String.valueOf(level));
    }

    public void battery_plus(View view){
        if(level < 7){
            level += 1;
            mImg.setImageLevel(level);
        }
        mText.setText(String.valueOf(level));
    }

    public void battery_minus(View view){
        if(level > 1) {
            level -= 1;
            mImg.setImageLevel(level);
        }
        mText.setText(String.valueOf(level));
    }
}