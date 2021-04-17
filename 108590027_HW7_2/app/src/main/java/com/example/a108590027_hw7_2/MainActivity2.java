package com.example.a108590027_hw7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTitle;
    private TextView mContent;
    private ImageView mImage;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTitle = findViewById(R.id.textView_title);
        mContent = findViewById(R.id.textView_content);
        mImage = findViewById(R.id.imageView);

        Intent intent = getIntent();
        message = intent.getStringExtra("Content");
        mContent.setText(message);
        message = intent.getStringExtra("Title");
        mTitle.setText(message);

        changeImage(message);
    }

    private void changeImage(String target){
        switch (target){
            case "Donut":
                mImage.setImageResource(R.drawable.donut_circle);
                mContent.setText(getString(R.string.lone_lorem));
                break;
            case "Froyo":
                mImage.setImageResource(R.drawable.froyo_circle);
                break;
            case "Ice cream":
                mImage.setImageResource(R.drawable.icecream_circle);
                break;
            case "Coffee":
                mImage.setImageResource(R.drawable.coffee);
                break;
            default:
                mImage.setImageResource(R.drawable.ic_add_for_fab);
                break;
        }
    }
}