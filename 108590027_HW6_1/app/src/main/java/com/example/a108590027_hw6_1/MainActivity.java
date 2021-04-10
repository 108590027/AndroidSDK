package com.example.a108590027_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String text = "Toppings:";
    ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("NonConstantResourceId")
    public void checkClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkBox1:
                if(checked){
                    items.add(getString(R.string.check1));
                }
                else{
                    items.remove(getString(R.string.check1));
                }
                break;

            case R.id.checkBox2:
                if(checked){
                    items.add(getString(R.string.check2));
                }
                else{
                    items.remove(getString(R.string.check2));
                }
                break;

            case R.id.checkBox3:
                if(checked){
                    items.add(getString(R.string.check3));
                }
                else{
                    items.remove(getString(R.string.check3));
                }
                break;

            case R.id.checkBox4:
                if(checked){
                    items.add(getString(R.string.check4));
                }
                else{
                    items.remove(getString(R.string.check4));
                }
                break;

            case R.id.checkBox5:
                if(checked){
                    items.add(getString(R.string.check5));
                }
                else{
                    items.remove(getString(R.string.check5));
                }
                break;

            default:
                break;
        }

    }

    public void buttonClicked(View view){
        int i;
        for(i=0;i<items.size();i++){
            text = text + " " + items.get(i);
        }
        showToast(text);
        text = "Toppings:";
    }
}