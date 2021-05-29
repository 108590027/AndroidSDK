package com.example.a108590027_hw12_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotifyManager;
    private static final int JOB_ID = 0;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private JobScheduler mJob;

    public class downloadJob extends JobService {
        @Override
        public boolean onStartJob(JobParameters params) {
            Log.d("jobTest", "onStartJob");
            deliverNotification();
            return false;
        }

        @Override
        public boolean onStopJob(JobParameters params) {
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    public void buttonClicked(View view){
        deliverNotification();
        createJob();
    }

    public void createNotificationChannel() {
        // Define notification manager object.
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Download notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies when the download start");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createJob(){
        mJob = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        JobInfo.Builder mBuilder = new JobInfo.Builder(JOB_ID, new ComponentName(getApplicationContext(), downloadJob.class.getName()))
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setPeriodic(TimeUnit.DAYS.toMillis(1));

        JobInfo mInfo = mBuilder.build();
        Log.d("jobInfo", mInfo.toString());
        if(mJob != null){
            mJob.schedule(mInfo);
        }
    }

    private void deliverNotification(){
        Intent contentIntent = new Intent(this, MainActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity(this, 0, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("Performing Work")
                .setContentText("Download in progress")
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(R.drawable.ic_job_run)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        mNotifyManager.notify(NOTIFICATION_ID, builder.build());
    }
}