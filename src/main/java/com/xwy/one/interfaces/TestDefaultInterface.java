package com.xwy.one.interfaces;

/**
 * @description:
 * @author: xwy
 * @create: 下午8:11 2021/5/28
 **/

public class TestDefaultInterface {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass.getName());

        MyInterface.show();
    }
}