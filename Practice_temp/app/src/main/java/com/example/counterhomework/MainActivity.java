package com.example.counterhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //use class name as tag
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";
    public static final int isReply = 1;
    private TextView mShowCount;
    private int mCount;
    private String currentCount;

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate");
        mCount = 0;
        mShowCount = (TextView) findViewById(R.id.textView);
        if (savedInstanceState != null) {
            mShowCount.setText(savedInstanceState.getString("currentCount"));
            mCount = Integer.parseInt(savedInstanceState.getString("currentCount"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentCount",mShowCount.getText().toString());
        Log.d(LOG_TAG, "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    public void toast_click(View view){
        //Launch MainActivity 2
        Intent intent = new Intent(this, MainActivity2.class);
        String msg = mShowCount.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, msg);
        startActivityForResult(intent, isReply);
    }


    public void count_click(View view){
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == isReply) {
            if (resultCode == RESULT_OK) {
                String setNumber = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mShowCount.setText(setNumber);
                mCount = Integer.parseInt(setNumber);
            }
        }
    }
}