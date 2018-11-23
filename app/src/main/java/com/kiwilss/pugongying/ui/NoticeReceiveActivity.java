package com.kiwilss.pugongying.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.kiwilss.pugongying.R;
import com.kiwilss.pugongying.utils.NotificationChannels;
import com.kiwilss.pugongying.utils.NotifyUtils;
import com.kiwilss.pugongying.utils.Utils;

/**
 * @author : Lss kiwilss
 * @FileName: NoticeReceiveActivity
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/21
 * @desc : ${DESCRIPTION}
 */
public class NoticeReceiveActivity extends AppCompatActivity {
    private android.widget.TextView tvnoticecontent;
    private android.widget.ImageView ivnoticeicon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_receive);
        this.ivnoticeicon = (ImageView) findViewById(R.id.iv_notice_icon);
        this.tvnoticecontent = (TextView) findViewById(R.id.tv_notice_content);


        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        if (!TextUtils.isEmpty(key)) {
            tvnoticecontent.setText(key);
        }

        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.scbg);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap1 = Utils.drawTextToBitmap(NoticeReceiveActivity.this, R.mipmap.scbg4, R.string.app_name);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivnoticeicon.setImageBitmap(bitmap1);
                    }
                });


            }
        }).start();

        //提前对通知渠道处理
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannels.createAllNotificationChannels(this);
        }

    }


    public void normal(View view) {
        NotifyUtils notifyUtils = new NotifyUtils(this, NotificationChannels.LOW);

        notifyUtils.notifyNormal(null,R.mipmap.logo,0,null,"title",
                "content",2,false,false,false);
    }

    public void custom1(View view) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notice);

        NotifyUtils notifyUtils = new NotifyUtils(this, NotificationChannels.LOW);

        notifyUtils.notifyCustomView(remoteViews,null,
                R.mipmap.logo,0,"hello",9,false,false,false);
    }

    public void custom2(View view) {
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.notice);

        NotifyUtils notifyUtils = new NotifyUtils(this, NotificationChannels.LOW);

        notifyUtils.notifyCustomView2(remoteViews,null,
                R.mipmap.logo,0,"hello",9,false,false,false);
    }

    public void bigIconListener(View view) {//大图在魅族上会重叠
        NotifyUtils notifyUtils = new NotifyUtils(this, NotificationChannels.LOW);
        notifyUtils.notifyBigPic(null,R.mipmap.cktl4,0,
                "hello","邮件","这是一封重要的邮件",
                R.mipmap.scbg,8,false,true,true);
    }


    public void testListener(View view) {

    }


    public void moreTextListener(View view) {
        NotifyUtils notifyUtils = new NotifyUtils(this, NotificationChannels.IMPORTANCE);

        notifyUtils.notifyNormailMoreline(null,R.mipmap.logo,0,
                null,"多行文字",
                "这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件" +
                        "这是一封重要的邮件这是一封重要的邮件这是一封重要的邮件",
                7,false,false,false);

    }

    public void buttonListener(View view) {
        NotifyUtils notifyUtils = new NotifyUtils(this, NotificationChannels.IMPORTANCE);
        notifyUtils.notifyButton(R.mipmap.cktl4,0,R.mipmap.cktl4,"左侧文字",null,
                R.mipmap.logo,"右侧",null,null,"带按钮的通知",
                "通知通知套中套总投资天天",23,false,false,false);
    }


    public void headupListener(View view) {

        NotifyUtils notifyUtils = new NotifyUtils(this, NotificationChannels.IMPORTANCE);
        notifyUtils.notifyHeadUp(null,R.mipmap.logo,R.mipmap.scbg,
                "通知","标题","简单内容",R.mipmap.ic_launcher,
                "左边",null,R.mipmap.scbg,"右边"
                ,null,22, false,false,false);

    }
}
