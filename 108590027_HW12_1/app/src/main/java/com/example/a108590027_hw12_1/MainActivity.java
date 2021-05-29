package com.example.a108590027_hw12_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ToggleButton mButton;
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.toggleButton);

        //---------------Alarm Manager---------------

        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        mButton.setChecked(alarmUp);

        PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //---------------Alarm Manager---------------

        mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        mButton.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        String mToast = "";
                        if(isChecked){
                            //deliverNotification(MainActivity.this);
                            if(alarmManager != null){
                                Calendar mCalendar = Calendar.getInstance();
                                mCalendar.set(Calendar.HOUR, 11);
                                mCalendar.set(Calendar.MINUTE, 11);
                                Log.d("calendar", mCalendar.toString());
                                alarmManager.setExact(AlarmManager.RTC_WAKEUP, mCalendar.getTimeInMillis(), notifyPendingIntent);
                            }
                            mToast = "Set alarm at 11:11!";
                        }
                        else {
                            //Cancel alarm when turn off
                            mNotificationManager.cancelAll();
                            if(alarmManager != null) {
                                alarmManager.cancel(notifyPendingIntent);
                            }
                            mToast = "Alarm is disabled";
                        }
                        Toast.makeText(MainActivity.this, mToast, Toast.LENGTH_SHORT).show();
                    }
                });
        createNotificationChannel();
    }

    /**
     * Creates a Notification channel, for OREO and higher.
     */
    public void createNotificationChannel() {
        // Create a notification manager object.
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription
                    ("Notifies every 15 minutes to stand up and walk");
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}