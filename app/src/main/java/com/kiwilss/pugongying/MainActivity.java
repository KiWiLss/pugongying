package com.kiwilss.pugongying;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kiwilss.pugongying.ui.MenuTestActivity;
import com.kiwilss.pugongying.ui.NoticeActivity;
import com.kiwilss.pugongying.ui.NoticeReceiveActivity;
import com.pgyersdk.feedback.PgyerFeedbackManager;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    private android.widget.TextView tvmaintest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvmaintest = (TextView) findViewById(R.id.tv_main_test);


        // 默认采用摇一摇弹出 Dialog 方式
        new PgyerFeedbackManager.PgyerFeedbackBuilder().builder().register();

//        // 采用摇一摇弹出 Activity 方式
//        new PgyerFeedbackManager.PgyerFeedbackBuilder()
//                .setDisplayType(PgyerFeedbackManager.TYPE.DIALOG_TYPE)
//                .builder()
//                .register();

        new PgyerFeedbackManager.PgyerFeedbackBuilder()
                .setShakeInvoke(true)       //fasle 则不触发摇一摇，最后需要调用 invoke 方法
                // true 设置需要调用 register 方法使摇一摇生效
                .setDisplayType(PgyerFeedbackManager.TYPE.DIALOG_TYPE)   //设置以Dialog 的方式打开
                .setColorDialogTitle("#FF0000")    //设置Dialog 标题的字体颜色，默认为颜色为#ffffff
                .setColorTitleBg("#FF0000")        //设置Dialog 标题栏的背景色，默认为颜色为#2E2D2D
                .setBarBackgroundColor("#FF0000")      // 设置顶部按钮和底部背景色，默认颜色为 #2E2D2D
                .setBarButtonPressedColor("#FF0000")        //设置顶部按钮和底部按钮按下时的反馈色 默认颜色为 #383737
                .setColorPickerBackgroundColor("#FF0000")   //设置颜色选择器的背景色,默认颜色为 #272828
                .setMoreParam("KEY1","VALUE1") //自定义的反馈数据
                .setMoreParam("KEY2","VALUE2") //自定义的反馈数据
                .builder()
                .invoke();                  //激活直接显示的方式


        /** 可选配置集成方式 **/
//        new PgyUpdateManager.Builder()
//                .setForced(true)                //设置是否强制更新
//                .setUserCanRetry(false)         //失败后是否提示重新下载
//                .setDeleteHistroyApk(true)     // 检查更新前是否删除本地历史 Apk， 默认为true
//                .register();
    }

    String mTest;
    @SuppressLint("CheckResult")
    public void exceptionListener(View view) {

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted){
                            Log.e(TAG, "accept: success");
                        }else if (permission.shouldShowRequestPermissionRationale){
                            Log.e(TAG, "accept: fail" );
                        }else {
                            Log.e(TAG, "accept: none" );
                        }
                    }
                });

//        rxPermissions
//                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .subscribe(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        if (aBoolean){
//                            Log.e("MMM", "accept: success" );
//                        }else {
//                            Log.e("MMM", "accept: fail" );
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.e("MMM", "accept: "+throwable.getMessage() );
//                    }
//                });


//        Toast.makeText(this, "再次更新1.2版本", Toast.LENGTH_SHORT).show();
//        try  {
//            // code
//            //int length = mTest.length();
//            tvmaintest.setText(mTest);
//        } catch (Exception e) {
///** 旧版本 **/
//            //PgyCrashManager.reportCaughtException(MainActivity.this, e); // 弃用，不推荐使用
///** 新版本 **/
//            PgyCrashManager.reportCaughtException(e);
//        }
    }

    @SuppressLint("SetTextI18n")
    public void sayHello(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);
        EditText editText = (EditText) findViewById(R.id.editText);
        textView.setText("Hello, killl" + editText.getText().toString() + "!");
    }

    public void noticeListener(View view) {
        startActivity(new Intent(this,NoticeActivity.class));
    }

    public void noticeListener2(View view) {
        startActivity(new Intent(this,NoticeReceiveActivity.class));
    }

    public void drawerListener(View view) {
        startActivity(new Intent(this,MenuTestActivity.class));
    }
}
