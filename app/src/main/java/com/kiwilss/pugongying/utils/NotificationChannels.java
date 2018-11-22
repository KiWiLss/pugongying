package com.kiwilss.pugongying.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Arrays;

public class NotificationChannels {
    public final static String CRITICAL = "critical";
    public final static String IMPORTANCE = "importance";
    public final static String DEFAULT = "default";
    public final static String LOW = "low";
    public final static String MEDIA = "media";

    public static final String CHANNEL_CRITICAL = "Critical events";
    public static final String CHANNEL_IMPORTANCE = "Importance events";
    public static final String CHANNEL_DEFAULT = "Default events";
    public static final String CHANNEL_LOW = "Low events";
    public static final String CHANNEL_MEDIA = "Media events";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void createAllNotificationChannels(Context context) {
        Log.e("MMM", "createAllNotificationChannels: " );
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(nm == null) {
            return;
        }

        //创建全部渠道,也可以根据需求创建
        NotificationChannel mediaChannel = new NotificationChannel(
                MEDIA,
                CHANNEL_MEDIA,
                NotificationManager.IMPORTANCE_DEFAULT);
        mediaChannel.setSound(null,null);
        mediaChannel.setVibrationPattern(null);

        nm.createNotificationChannels(Arrays.asList(
                new NotificationChannel(
                        CRITICAL,
                        CHANNEL_CRITICAL,
                        NotificationManager.IMPORTANCE_HIGH),
                new NotificationChannel(
                        IMPORTANCE,
                       CHANNEL_IMPORTANCE,
                        NotificationManager.IMPORTANCE_DEFAULT),
                new NotificationChannel(
                        DEFAULT,
                        CHANNEL_DEFAULT,
                        NotificationManager.IMPORTANCE_LOW),
                new NotificationChannel(
                        LOW,
                        CHANNEL_LOW,
                        NotificationManager.IMPORTANCE_MIN),
                //custom notification channel
                mediaChannel
        ));
    }
}

