package com.kiwilss.pugongying.ui.factory;

import com.kiwilss.pugongying.model.Dependency;
import com.kiwilss.pugongying.model.NullObject;
import com.kiwilss.pugongying.null_judge.DependencyBase;
import com.kiwilss.pugongying.null_judge.Nullable;

public class Factory {
    
    public static DependencyBase get(Nullable dependencyBase){
        if (dependencyBase == null){
            return new NullObject();
        }
        return new Dependency();
    }
    
}

