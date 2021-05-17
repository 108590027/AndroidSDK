package com.example.a108590027_hw10_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private String mUrl;
    private String mMethod;
    private EditText mEdit;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUrl = "";
        mMethod = "";
        mEdit = findViewById(R.id.editText_url);
        mResult = findViewById(R.id.textView_content);

        if (getSupportLoaderManager().getLoader(0) != null){
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle){
        return new sourceTask(this, mUrl, mMethod);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String result) {
        try{
            mResult.setText(result);
        }
        catch (Exception e){
            e.printStackTrace();
            mResult.setText("Can\'t find anything");
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public void radio_selected(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radio_http:
                if(checked) {
                    mMethod = "http";
                }
                break;

            case R.id.radio_https:
                if(checked) {
                    mMethod = "https";
                }
                break;

            default:
                break;
        }
    }

    public void btn_clicked(View view){
        ConnectivityManager mConnectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mNetwork = null;
        if (mConnectivity != null){
            mNetwork = mConnectivity.getActiveNetworkInfo();
        }

        if(mNetwork != null && mNetwork.isConnected())
        {
            mUrl = mEdit.getText().toString();
            if(mMethod == ""){
                Toast.makeText(this, "Choose http or https", Toast.LENGTH_LONG).show();
            }
            if(mEdit.getText().length() == 0){
                Toast.makeText(this, "Enter your Url!", Toast.LENGTH_LONG).show();
            }
            if(mMethod != "" && mEdit.getText().length() != 0){
                Bundle mBundle = new Bundle();
                getSupportLoaderManager().restartLoader(0, mBundle, this);
            }
        }
        else{
            Toast.makeText(this, "Check your network!", Toast.LENGTH_LONG).show();
        }
        Log.d("url", mUrl);
    }
}