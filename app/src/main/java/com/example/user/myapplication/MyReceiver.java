package com.example.user.myapplication;

import android.app.NotificationManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }
    static int id=7000;

    @Override
    public void onReceive(Context context, Intent intent) {
        String name=intent.getStringExtra("Key_Name");
        Intent newintent=new Intent();
        newintent.setClass(context,ActivityNotification.class)
        PendingIntent pendingIntent =PendingIntent.getActivity(context, 0, newintent, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification notify = newNotification(context, pendingIntent, "(New) Broadcast is received.",name);
        NotificationManager notificationManager =(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(id++, notify);
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @SuppressLint("NewApi")
    private Notification newNotification(
            Context context, PendingIntent pi,
            String title, String msg) {
        Notification.Builder builder =
                new Notification.Builder(context);

        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pi);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();
        return notify;
    }

}
