/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.simpleasynctask;

import android.os.AsyncTask;
import android.support.annotation.IntegerRes;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

/**
 * The SimpleAsyncTask class extends AsyncTask to perform a very simple
 * background task -- in this case, it just sleeps for a random amount of time.
 */

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    // The TextView where we will show results
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mBar;

    // Constructor that provides a reference to the TextView from the MainActivity
    SimpleAsyncTask(TextView tv, ProgressBar pb) {
            mTextView = new WeakReference<>(tv);
            mBar = new WeakReference<>(pb);
    }

    /**
     * Runs on the background thread.
     *
     * @param voids No parameters in this use case.
     * @return Returns the string including the amount of time that
     * the background thread slept.
     */
    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10.
        long pressTime = Calendar.getInstance().getTimeInMillis();
        long currentTime = Calendar.getInstance().getTimeInMillis();
        Random r = new Random();
        long time_milli = currentTime-pressTime;
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running.
        int s = n * 200;
        while(time_milli <= s){
            int time = (int)time_milli * 100;
            onProgressUpdate(time/s);
            currentTime = Calendar.getInstance().getTimeInMillis();
            time_milli = currentTime-pressTime;
        }


        // Sleep for the random amount of time.
        /*try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        /*for(int i=1;i<=s;i++){
            mBar.get().setProgress(i/s*100);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        // Return a String result.
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    /**
     * Does something with the result on the UI thread; in this case
     * updates the TextView.
     */
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    protected void onProgressUpdate(Integer... values) {
        Log.d("progress", Integer.toString(values[0]));
        mBar.get().setProgress(values[0]);
    }

}
