package com.kiwilss.pugongying.test;

/**
 * @author : Lss kiwilss
 * @FileName: Person
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/23
 * @desc : ${DESCRIPTION}
 */
public class Person implements IPerson {
    private String name;
    private int age;

    public Person(int age) {
        this.age = age;
    }

    //@Override
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
