package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //use class name as tag
    private static final String TAG = MainActivity.class.getSimpleName();
    //private Context content = getApplicationContext();

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,  "Test creating the URL...");
    }

    public void toast_click(View view){
        String msg = "Hello Toast!!!";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void zero_click(View view){
        TextView mShowCount = (TextView) findViewById(R.id.textView);
        view.setBackgroundColor(Color.GRAY);
        mShowCount.setText("0");
    }

    public void count_click(View view){
        TextView mShowCount = (TextView) findViewById(R.id.textView);
        TextView zero_btn = (TextView) findViewById(R.id.button3);
        zero_btn.setBackgroundColor(Color.parseColor("#FA0BFA"));
        int mcount = Integer.parseInt(mShowCount.getText().toString());
        mcount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mcount));
        }
    }
}