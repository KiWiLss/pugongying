package com.kiwilss.pugongying.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.kiwilss.pugongying.R;

/**
 * @author : Lss kiwilss
 * @FileName: MenuTestActivity
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/27
 * @desc : ${DESCRIPTION}
 */
public class MenuTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }



    }
}
