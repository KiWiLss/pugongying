package com.kiwilss.pugongying;

import org.junit.Before;
import org.junit.Test;

/**
 * FileName: MyAppTest
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/10/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyAppTest {

    private MyApp mMyApp;

    @Before
    public void setUp() throws Exception {
        mMyApp = new MyApp();
    }

    @Test
    public void onCreate() {
        mMyApp.testCheck();
    }
}