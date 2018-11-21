package com.kiwilss.pugongying;

import android.app.Application;
import android.util.Log;

import com.pgyersdk.crash.PgyCrashManager;
import com.pgyersdk.crash.PgyerCrashObservable;
import com.pgyersdk.crash.PgyerObserver;

/**
 * FileName: MyApp
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/9/12
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyApp extends Application {

    public static final String TAG  =  "MMM";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG, "onCreate: ");
        //一、注册Crash接口（必选）
        PgyCrashManager.register(); //推荐使用

            //这个方法慎用
        PgyerCrashObservable.get().attach(new PgyerObserver() {
            @Override
            public void receivedCrash(Thread thread, Throwable throwable) {
                // 禁止做耗时操作
                // 添加自定义操作
                Log.e(TAG, "receivedCrash: " + thread.getName()+"--"+throwable.getMessage());
            }
        });

        PgyCrashManager.setIsIgnoreDefaultHander(false); //默认设置为false;
        //设置为 true ,则忽略系统默认Crash 操作，SDK 会重启启动 app 的当前页面

        //SophixManager.getInstance().queryAndLoadNewPatch();

//        LoadSir.beginBuilder()
//                .addCallback(new ErrorCallback())//添加各种状态页
//                .addCallback(new EmptyCallback())
//                .addCallback(new LoadingCallback())
//                .addCallback(new TimeoutCallback())
//                .addCallback(new CustomCallback())
//                .setDefaultCallback(LoadingCallback.class)//设置默认状态页
//                .commit();
    }
    public void testCheck(){
        System.out.println("单元测试");
    }

    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
//    @Keep
//    @SophixEntry(MyApp.class)
//    static class RealApplicationStub {}
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
////         如果需要使用MultiDex，需要在此处调用。
////         MultiDex.install(this);
//        initSophix();
//    }
//    private void initSophix() {
//        String appVersion = "0.0.0";
//        try {
//            appVersion = this.getPackageManager()
//                    .getPackageInfo(this.getPackageName(), 0)
//                    .versionName;
//        } catch (Exception e) {
//        }
//        final SophixManager instance = SophixManager.getInstance();
//        instance.setContext(this)
//                .setAppVersion(appVersion)
//                .setSecretMetaData("24874674", "2a174d41ec8447651bad1688bb19343a",
//                        "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCw/NjHltwDkNfU3pjjquNpRK6A6wTBntzzj3y8FkS+hfJXU+wCqHQjNREEnFB/E4+gx673DWNG4zBXVHnX8WNa0ek9RgXQkRe0tir1V7eHC8qKZoHJ8KQh9HtDS5pSGS+zp9gWanzrCVHwInI9K/flcqfR8s7eJ22kc+jS3Gj8YCU/1VUXP89YiLQereK/VognHiwsR1ci7VngsQNKIYHTn+yu1/GBshzrvEXFJNgHxyNhwuctKjt2+8WXIogW5Y3Si7ghPejBT4+xJuW4kt6y2xieKV9QeOD9tZL6ltk/e7W392NYj6D1ibr3CoIWr1mo7OtNtCSZt6JVysQKe2U7AgMBAAECggEAXI8/R9JLqcm8NmVbi+U5HTqAEIfYavIMF4x47VywAvvGK4mGKjWy1x7PkZu2NV8jhDAp/qYPv2jdRS62sgpZrYuN8S+HpvXacfW7Laf8ITI3cH3/bn7dN6zGMgF96WWmnswupDp4reqn4XACUp+F+4ck4RWcvm3cV18O6ge/GAzGNmM1+SdFWBDMXgPzZ3nSgT0xvPXFqarWbuYT6qmEVNDEed+NidwhPvuuiG8gABuG1pIe9iZjCS8CjOdv41EdD3DV8wi3guFC2bBD+qMJHLlVUK0iNIL6/0f4HDTQjuFUi1BFM8sJknS81hKp/Xu4rCOvKreCi32xAVo983I/UQKBgQD8+SALa4vpLrvZlCzxaGUE56uJBzCBfMhOyhVygasMMXCrjVaCUYqjC8ZRFLdgHSJvvqP8BCOjaGdPKD2HXXfFR1Wp7Hj84t2ILIHnexOtlY4h1+dVcnboK5oO6kENQj7dg0k/OSMevYr1p9cXHniESSKP89w5q+ldTK6ODffa1wKBgQCzGvkEFbJTqr9ruLxbc521THJNJKULOPDkeXOVjs359KqbPBiGrPt1jKCSQkoAVxHwfuNNg0240fWb+V+7KlN5Vgf1xI/IATdiEV8GIstVvsv4Y0HxPIOrz6Z+Ica9mxP6L5hXkfwlf+gR0Why5pqbLNFePvqj386BRkYWqa3APQKBgBWL6ozOdjZAQsO/eSx+pcwLJ3MeZ6U/yZfcYoNERBtfwqb5/NpQs6w7foK9bvkCwkIeTL1UZOywIcx+Mu9qqJ7m+obkm1F+yTul/tKGiyCH0nlTeGKwwyv3OsH2dd/5On2Hhx+ZcEJYBpPx3cIcWEt8JzN3o9RNrizCMUPsMKY1AoGAP9W3Nwt8mXFb9ErNZ1LXvMxYWMJcyJks0mGvHnjdVN8tB1Lt8uIoZYcPm9Fgiqp9zFeNMA1CYEME5OiGhDDbu308LQ43qLM2SA+k7IzuJ8tu60KFODO3Qj8qOf5T1TQ2dI8OHvf7BGqIDgGy1nD2XaQlow+TSWD1OwIO7Pjg4okCgYBayPdlwOnjd8FwbbnIkc4M3iMLl70UECXuQrNvUaKotvFb0B4Ui4oDF6m6MxMklsaYzYIkhztlo5QDBsYPS1eSS/uPu4I0MOLDI/VFMz88KtBE3DQM4uU7K3Mi/w44dh7uy8aIRo7793UbKP2vSPigTHzZIeFxaF18P1oCl2VdLQ==")
//                .setEnableDebug(true)
//                .setEnableFullLog()
//                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
//                    @Override
//                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
//                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
//                            Log.e(TAG, "sophix load patch success!");
//                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
//                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
//                            Log.e(TAG, "sophix preload patch success. restart app to make effect.");
//                        }
//                    }
//                }).initialize();
//    }
}
