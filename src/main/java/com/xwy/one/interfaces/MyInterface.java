package com.xwy.one.interfaces;

public interface MyInterface {

    default String getName(){
        return "MyInterface name";
    }

    public static void show(){
        System.out.println("接口中的静态方法");
    }
}