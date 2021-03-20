package com.example.a108590027_hw4_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mShowCount;
    private int mCount;
    private String currentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.TextView_Count);
        mCount = 0;
        if(savedInstanceState != null){
            mShowCount.setText(savedInstanceState.getString("currentCount"));
            mCount = Integer.parseInt(savedInstanceState.getString("currentCount"));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentCount",mShowCount.getText().toString());
    }

    public void countUp(View View){
        mCount++;
        mShowCount.setText(Integer.toString(mCount));
    }
}