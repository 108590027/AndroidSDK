package com.example.a108590027_hw10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private String mUrl;
    private EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUrl = "";
        mEdit = findViewById(R.id.editText_url);
    }

    public void radio_selected(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radio_http:
                if(checked) {
                    mUrl = "http://";
                }
                break;

            case R.id.radio_https:
                if(checked) {
                    mUrl = "https://";
                }
                break;

            default:
                break;
        }
    }

    public void btn_clicked(View view){
        mUrl = mUrl + mEdit.getText().toString();
        Log.d("url", mUrl);
    }
}