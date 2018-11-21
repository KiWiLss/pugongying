package com.kiwilss.pugongying.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiwilss.pugongying.R;
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


    }


}
