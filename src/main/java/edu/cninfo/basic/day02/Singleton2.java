package edu.cninfo.basic.day02;

import java.io.Serializable;

public class Singleton2 implements Serializable {
    private String name;
    private int count;
    private static Singleton2 instance = new Singleton2("sigletone", 1);

    private Singleton2(String name, int count) {
        /**防止反射对单例的破坏*/
        if (instance != null) {
            throw new RuntimeException("不能通过返回获取单例类");
        }
        this.name = name;
        this.count = count;
    }

    public static Singleton2 getInstance() {
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
