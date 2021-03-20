package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsite;
    private EditText mLocation;
    private EditText mShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsite = findViewById(R.id.website_editText);
        mLocation = findViewById(R.id.map_editText);
        mShare = findViewById(R.id.share_editText);
    }

    public void openWebsite(View View){
        String url = mWebsite.getText().toString();
        Uri web = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, web);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openMap(View View){
        String loc = mLocation.getText().toString();
        Uri address = Uri.parse("geo:0,0?q="+ loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else{
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void shareText(View View){
        String text = mShare.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();
    }

    public void takePic(View View){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}