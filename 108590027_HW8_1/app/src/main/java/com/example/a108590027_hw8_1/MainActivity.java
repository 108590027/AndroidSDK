package com.example.a108590027_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int level = 3;
    private ImageView mImg;
    private TextView mText;
    private Button mPlus;
    private Button mMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlus = findViewById(R.id.button_plus);
        mMinus = findViewById(R.id.button_minus);

        mImg = findViewById(R.id.imageView);
        mImg.setImageLevel(level);

        mText = findViewById(R.id.textView_level);
        mText.setText(String.valueOf(level));
    }

    public void battery_plus(View view){
        if(level < 6){
            level += 1;
            mImg.setImageLevel(level);
        }
        if(level == 6){
            mPlus.setClickable(false);
        }
        mMinus.setClickable(true);
        mText.setText(String.valueOf(level));
    }

    public void battery_minus(View view){
        if(level > 0) {
            level -= 1;
            mImg.setImageLevel(level);
        }
        if(level == 0){
            mMinus.setClickable(false);
        }
        mPlus.setClickable(true);
        mText.setText(String.valueOf(level));
    }
}