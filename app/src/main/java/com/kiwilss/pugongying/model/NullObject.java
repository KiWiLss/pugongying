package com.kiwilss.pugongying.model;

import com.kiwilss.pugongying.null_judge.DependencyBase;

/**
 * @author : Lss kiwilss
 * @FileName: NullObject
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/23
 * @desc : ${DESCRIPTION}
 */
public class NullObject implements DependencyBase {
    @Override
    public void Operation() {

    }

    @Override
    public boolean isNull() {
        return true;
    }
}
