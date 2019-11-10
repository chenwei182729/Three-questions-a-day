package edu.cninfo.basic.day02;

import java.io.Serializable;

public class Singleton implements Serializable {
    private String name;
    private int count;
    private static Singleton instance = new Singleton("sigletone", 1);

    private Singleton(String name, int count){
        if (instance != null) {
            throw new RuntimeException("不能通过返回获取单例类");
        }
        this.name = name;
        this.count = count;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public String show() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    private Object readResolve() {
        System.out.println("read resolve");
        return instance;
    }
}
