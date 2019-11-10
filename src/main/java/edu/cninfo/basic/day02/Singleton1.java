package edu.cninfo.basic.day02;

import java.io.Serializable;

public class Singleton1 implements Serializable {
    private String name;
    private int count;
    private static Singleton1 instance = new Singleton1("sigletone", 1);

    private Singleton1(String name, int count) {
        /**防止反射对单例的破坏*/
        if (instance != null) {
            throw new RuntimeException("不能通过返回获取单例类");
        }
        this.name = name;
        this.count = count;
    }

    public static Singleton1 getInstance() {
        return instance;
    }

    public String show() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
