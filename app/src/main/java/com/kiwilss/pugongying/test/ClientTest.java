package com.kiwilss.pugongying.test;

/**
 * @author : Lss kiwilss
 * @FileName: ClientTest
 * @e-mail : kiwilss@163.com
 * @time : 2018/11/23
 * @desc : ${DESCRIPTION}
 */
public class ClientTest {
    public static void main(String[] args) {
        Person alice = new Person("alice", 9);
        Person kitty = new Person(8);

        System.out.println(alice.getName());
        System.out.println(kitty.getName().length());

        System.out.println(kitty.getName() == null);

    }
}
