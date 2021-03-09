package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //use class name as tag
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    private TextView mShowCount;
    private int mcount;
    private TextView mMessageEditText;


    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (TextView) findViewById(R.id.textView);
        mcount = 0;
        mShowCount = (TextView) findViewById(R.id.textView);
        Log.d(TAG,  "Test creating the URL...");
    }

    public void toast_click(View view){
        //Launch MainActivity 2
        Intent intent = new Intent(this, MainActivity2.class);
        String msg = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivity(intent);
    }


    public void count_click(View view){
        mcount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mcount));
        }
    }
}