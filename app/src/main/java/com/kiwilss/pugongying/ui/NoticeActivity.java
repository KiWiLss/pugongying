package com.kiwilss.pugongying.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.kiwilss.pugongying.R;
import com.kiwilss.pugongying.utils.NotifyUtil;

/**
 * @author : Lss kiwilss
 * @FileName: NoticeActivity
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/21
 * @desc : ${DESCRIPTION}
 */
public class NoticeActivity extends AppCompatActivity {

    public static final String TAG = "MMM";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);


    }

    public void testOne(View view) {
        //自定义打开的界面
        Intent intent = new Intent(this, NoticeReceiveActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent里面可以携带参数
        intent.putExtra("key","来自通知");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 9
                , intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //1,获取NotificationManager实例
         nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //2,创建Notification实例
        Notification.Builder builder = new Notification.Builder(this);
         builder.setAutoCancel(true)  //设置点击通知后自动取消通知
                .setContentTitle("标题")  //通知标题
                .setContentText("内容简介")  //通知第二行的内容
                .setContentIntent(pendingIntent)  //点击通知后，发送指定的PendingIntent
                .setSmallIcon(R.mipmap.scbg);  //通知图标，必须设置否则通知不显示


        Notification build = builder.build();
        //3,发送通知
        nm.notify(1,build);
    }

    NotificationManager nm;
    public void testOne2(View view) {
        //自定义打开的界面
        Intent intent = new Intent(this, NoticeReceiveActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent里面可以携带参数
        intent.putExtra("key","来自通知");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 9
                , intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //1,获取NotificationManager实例
         nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //2,获取通知的构造器
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder
                .setContentTitle("任意标题")//设置标题
                .setContentText("设置任意内容白费劲啊飞机的飞机啊房间爱疯没法讲方法诶白费劲啊飞机的飞机啊房间爱疯没法讲方法诶白费劲啊飞机的飞机啊房间爱疯没法讲方法诶白费劲啊飞机的飞机啊房间爱疯没法讲方法诶")
                .setAutoCancel(true)//设置可取消
                .setContentInfo("设置任意附件信息")
                .setShowWhen(true)//设置是否显示时间
                .setTicker("通知来了")//设置通知首次出现提示
                .setPriority(Notification.PRIORITY_DEFAULT)//设置通知的优先级,默认为0
                .setDefaults(Notification.DEFAULT_VIBRATE)//设置振动声音等,需要振动权限
                .setContentIntent(pendingIntent)//自定义打开的界面
                .setWhen(System.currentTimeMillis())//设置时间,long类型自动转换
                .setSmallIcon(R.mipmap.scbg)//设置小图标,必须设置
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.cktl4))//设置大图标
                .build();
        //3,发送通知
        nm.notify(2,notification);
    }


    public void cancelOne(View view) {
        //取消对应的id的通知
        nm.cancel(2);
    }

    public void bigIcon(View view) {//魅族会重叠
        Intent intent = new Intent(this, NoticeReceiveActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //intent里面可以携带参数
        intent.putExtra("key","来自通知");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 9
                , intent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotifyUtil notifyUtil = new NotifyUtil(this, 99);
        notifyUtil.notify_bigPic(pendingIntent,R.mipmap.cktl4,
                "hello","邮件","这是一封重要的邮件",
                R.mipmap.scbg,false,true,true);
        //showBigPictureNotificationWithMZ(this);
    }

    private void showBigPictureNotificationWithMZ(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context);

        builder.setAutoCancel(true)  //设置点击通知后自动取消通知
                .setContentTitle("标题")  //通知标题
                .setContentText("内容简介")  //通知第二行的内容
                //.setContentIntent(pendingIntent)  //点击通知后，发送指定的PendingIntent
                .setSmallIcon(R.mipmap.scbg);  //通知图标，必须设置否则通知不显示

        Notification notification = builder.build();

        notification.bigContentView = new RemoteViews(getPackageName(), R.layout.notice);
        notificationManager.notify(0, notification);
    }

    public void bigLayout(View view) {
//        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        Notification notification = builder.setTicker("设置滚动提示的文字")
//                .setContentTitle("标题")//设置通知的标题
//                .setContentText("通知的内容")//设置通知的内容
//                .setSmallIcon(R.mipmap.logo)
//                //.setWhen(System.currentTimeMillis())//设置时间
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.cktl4))
//                //.setContentInfo("设置附带信息")
//                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)//设置声音和振动
//                //.setTicker("设置滚动提示的文字")
//                //.setOngoing(false)//是否可以手动移除
//                .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText("白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
//                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
//                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
//                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶"))
//                .setPriority(1)//设置优先级
//                .build();
//        nm.notify(3,notification);//发送通知

        NotifyUtil notifyUtil = new NotifyUtil(this, 99);
        notifyUtil.notify_normail_moreline(null,
                R.mipmap.cktl4,
                "hello","邮件","这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件" +
                        "这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件",
                false,true,true);
    }

    public void buttonNotice(View view) {
        NotifyUtil notifyUtil = new NotifyUtil(this, 99);
        notifyUtil.notify_button(R.mipmap.cktl4,R.mipmap.cktl4,"左侧文字",null,
                R.mipmap.logo,"右侧",null,null,"带按钮的通知",
                "通知通知套中套总投资天天",false,false,false);
    }

    public void customListener(View view) {//自定义布局高度默认是64dp
//        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notice);
//        //可以设置布局内容,对应的id
//        //remoteViews.setTextViewText(R.id.tv_main_test,"内容");
//        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        //2,获取通知的构造器
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
//        Notification notification = builder
//                .setContentTitle("任意标题")//设置标题
//                .setContentText("设置任意内容白费劲啊飞机的飞机啊房间爱疯没法讲方法诶白费劲啊飞机的飞机啊房间爱疯没法讲方法诶白费劲啊飞机的飞机啊房间爱疯没法讲方法诶白费劲啊飞机的飞机啊房间爱疯没法讲方法诶")
//                .setAutoCancel(true)//设置可取消
//                .setContentInfo("设置任意附件信息")
//                .setTicker("通知来了")//设置通知首次出现提示
//                .setPriority(Notification.PRIORITY_DEFAULT)//设置通知的优先级,默认为0
//                .setDefaults(Notification.DEFAULT_VIBRATE)//设置振动声音等,需要振动权限
//                //.setContentIntent(pendingIntent)//自定义打开的界面
//                .setWhen(System.currentTimeMillis())//设置时间,long类型自动转换
//                .setSmallIcon(R.mipmap.scbg)//设置小图标,必须设置
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.cktl4))//设置大图标
//                .setContent(remoteViews)
//                .build();
//        //3,发送通知
//        nm.notify(2,notification);

        //不限制高度
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notice);
        //可以设置布局内容,对应的id
        //remoteViews.setTextViewText(R.id.tv_main_test,"内容");
        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //2,获取通知的构造器
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        //设置各类信息等
        builder.setSmallIcon(R.mipmap.logo);//必设置
        Notification notification = builder.build();
        notification.bigContentView=remoteViews;
        nm.notify(2,notification);
    }

    public void headup(View view) {
        NotifyUtil notifyUtil = new NotifyUtil(this, 99);
        notifyUtil.notify_HeadUp(null,R.mipmap.logo,R.mipmap.scbg,
                "通知","标题","简单内容",R.mipmap.ic_launcher,
                "左边",null,R.mipmap.scbg,"右边"
        ,null,false,false,false);
    }

    public void createChennal(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //等级高,会以弹窗形式提醒
            String channelId = "chat";
            String channelName = "聊天消息";
            int importanceHigh = NotificationManager.IMPORTANCE_HIGH;
            createNotificationChannel(channelId, channelName, importanceHigh);

            channelId = "subscribe";
            channelName = "订阅消息";
            importanceHigh = NotificationManager.IMPORTANCE_DEFAULT;
            createNotificationChannel(channelId, channelName, importanceHigh);

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(String channelId, String channelName, int importanceHigh) {
        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importanceHigh);
        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public void simpleNotice(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //第2个参数,生成的通知渠道
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "chat");
        Notification notification = builder.setContentTitle("收到一条聊天消息")
                .setContentText("今天中午吃什么？")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.cktl4)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.scbg))
                .setAutoCancel(true)
                .build();
        manager.notify(1, notification);
    }


    public void subscribeNotice(View view) {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(this, "subscribe")
                .setContentTitle("收到一条订阅消息")
                .setContentText("地铁沿线30万商铺抢购中！")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.logo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.cktl4))
                .setAutoCancel(true)
                .build();
        manager.notify(2, notification);
    }

    public void managerChannel(View view) {
        //
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel chat = manager.getNotificationChannel("chat");
            Log.e(TAG, "managerChannel: "+chat.getImportance() );
            //点了不在通知以后
            //NotificationManager.IMPORTANCE_NONE
            if (chat.getImportance() == NotificationManager.IMPORTANCE_NONE){
                Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                intent.putExtra(Settings.EXTRA_CHANNEL_ID, chat.getId());
                startActivity(intent);
            }else {
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(this, "chat");
                Notification notification = builder.setContentTitle("收到一条聊天消息")
                        .setContentText("今天中午吃什么？")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.cktl4)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.scbg))
                        .setAutoCancel(true)
                        .build();
                manager.notify(1, notification);
            }

        }

    }

    public void testtest(View view) {

        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification = builder.setTicker("设置滚动提示的文字")
                .setContentTitle("标题")//设置通知的标题
                .setContentText("通知的内容")//设置通知的内容
                .setSmallIcon(R.mipmap.logo)
                //.setWhen(System.currentTimeMillis())//设置时间
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.cktl4))
                //.setContentInfo("设置附带信息")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)//设置声音和振动
                //.setTicker("设置滚动提示的文字")
                //.setOngoing(false)//是否可以手动移除
                .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶" +
                                "白费劲啊飞机的飞机啊房间爱疯没法讲方法诶"))
                .setPriority(1)//设置优先级
                .build();
        nm.notify(3,notification);//发送通知

//        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notice);
//
//        NotifyUtil notifyUtil = new NotifyUtil(this, 99);
//        notifyUtil.notify_customview(remoteViews,null,
//                R.mipmap.logo,"hello",false,false,false);

//        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        sendBigPictureStyleNotification(this,nm);
    }


    public void sendBigPictureStyleNotification(Context context, NotificationManager nm) {
        //创建点击通知时发送的广播
        Intent intent = new Intent(context,NoticeReceiveActivity.class);
        //intent.setAction(ACTION_BIG_PICTURE_STYLE);
        PendingIntent pi = PendingIntent.getService(context,0,intent,0);
        //创建大视图样式
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .setBigContentTitle("Big picture style notification ~ Expand title")
                .setSummaryText("Demo for big picture style notification ! ~ Expand summery")
                .bigPicture(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.cktl4));
        //创建通知
        Notification.Builder nb = new Notification.Builder(context)
                //设置通知左侧的小图标
                .setSmallIcon(R.mipmap.logo)
                //设置通知标题
                .setContentTitle("Big picture style notification")
                //设置通知内容
                .setContentText("Demo for big picture style notification !")
                //设置点击通知后自动删除通知
                .setAutoCancel(true)
                //设置显示通知时间
                .setShowWhen(true)
                //设置点击通知时的响应事件
                .setContentIntent(pi)
                //设置大视图样式通知
                .setStyle(bigPictureStyle);
        //发送通知
        nm.notify(88,nb.build());
    }

}
