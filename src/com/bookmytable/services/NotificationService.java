package com.bookmytable.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;

import com.bookmytable.MenuActivity;
import com.bookmytable.R;

/**
 * Created by Pranit on 11/30/13.
 */
public class NotificationService extends Service {

    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent myIntent = new Intent(this, MenuActivity.class);
        int id = (int) (Math.random() * 10000);
        myIntent.putExtra("id", id);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, myIntent, 0);

        Notification mNotification = new Notification.Builder(this)
                .setContentTitle("Your Table Is Ready!")
                .setContentText(intent.getStringExtra("message"))
                .setSmallIcon(R.drawable.logo_notification)
                .setContentIntent(pendingIntent)
                .setSound(soundUri)
                .addAction(R.drawable.login, "Proceed to Check-In", pendingIntent)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(id, mNotification);
    }
}

