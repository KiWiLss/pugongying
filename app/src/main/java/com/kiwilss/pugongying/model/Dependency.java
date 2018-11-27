package com.kiwilss.pugongying.model;

import com.kiwilss.pugongying.null_judge.DependencyBase;
import com.kiwilss.pugongying.null_judge.Nullable;

/**
 * @author : Lss kiwilss
 * @FileName: Dependency
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/23
 * @desc : ${DESCRIPTION}
 */
public class Dependency implements DependencyBase,Nullable {
    @Override
    public void Operation() {

    }

    @Override
    public boolean isNull() {
        return false;
    }
}
