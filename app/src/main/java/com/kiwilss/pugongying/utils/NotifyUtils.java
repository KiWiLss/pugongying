package com.kiwilss.pugongying.utils;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

/**
 * @author : Lss kiwilss
 * @FileName: NotifyUtils
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/21
 * @desc : ${DESCRIPTION}
 */
public class NotifyUtils {

    private Context mContext;
    private NotificationManager mNm;
    private NotificationCompat.Builder mBuilder;


    public NotifyUtils(Context context,String channel,int importanceId) {
        mContext = context;
        // 获取系统服务来初始化对象
        mNm = (NotificationManager) mContext
                .getSystemService(Activity.NOTIFICATION_SERVICE);
        //判断是否是8.0,8.0创建通知渠道
        if (TextUtils.isEmpty(channel)) {
            mBuilder = new NotificationCompat.Builder(mContext);
        }else {
            createNotifyChannel(channel,importanceId);
            mBuilder = new NotificationCompat.Builder(mContext,channel);
        }

    }

    /**
     * @param channel 渠道名
     * @param importanceId 渠道优先级
     */
    private void createNotifyChannel(String channel,int importanceId) {

    }


}
