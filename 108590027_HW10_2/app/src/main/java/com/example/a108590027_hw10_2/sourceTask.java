package com.example.a108590027_hw10_2;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class sourceTask extends AsyncTaskLoader<String> {
    Context mContext;
    private String mUrl;
    private String mMethod;

    public sourceTask(@NonNull Context context, String website, String method){
        super(context);
        mContext = context;
        mUrl = website;
        mMethod = method;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return getSourceCode(mContext, mUrl, mMethod);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    public String getSourceCode(Context mContext, String mWebsite, String mMethod) {
        HttpURLConnection mConnection = null;
        BufferedReader mBuffer = null;
        String htmlCode = "";
        Uri location;
        try{
            location = Uri.parse(mWebsite).buildUpon().scheme(mMethod).build();
            URL locationUrl = new URL(location.toString());
            mConnection = (HttpURLConnection) locationUrl.openConnection();
            mConnection.setRequestMethod("GET");
            mConnection.connect();
            InputStream input = mConnection.getInputStream();
            mBuffer = new BufferedReader(new InputStreamReader(input));
            StringBuilder tmp = new StringBuilder();
            String lines;
            while ((lines = mBuffer.readLine()) != null){
                tmp.append(lines);
                tmp.append("\n");
            }
            if(tmp.length() == 0){
                return null;
            }
            htmlCode = tmp.toString();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(mConnection == null){
                mConnection.disconnect();
            }
            if(mBuffer != null){
                try {
                    mBuffer.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return htmlCode;
    }
}
