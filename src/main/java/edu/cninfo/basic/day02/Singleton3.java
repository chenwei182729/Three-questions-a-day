package edu.cninfo.basic.day02;

import java.io.Serializable;

public class Singleton3 implements Serializable {
    private String name;
    private int count;
    private static Singleton3 instance = new Singleton3("sigletone", 1);

    private Singleton3(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public static Singleton3 getInstance() {
        return instance;
    }

    public String show() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    /**
     * 防止反序列化对单例的破坏
     */
    private Object readResolve() {
        System.out.println("read resolve");
        return instance;
    }
}
