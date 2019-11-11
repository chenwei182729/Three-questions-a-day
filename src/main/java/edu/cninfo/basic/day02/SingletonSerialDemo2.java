package edu.cninfo.basic.day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化对单例的破坏
 */
public class SingletonSerialDemo2 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Singleton singleton1 = Singleton.getInstance();
        oos.writeObject(singleton1);
        System.out.println(singleton1);
        System.out.println(singleton1.show());
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("object.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton singleton2 = (Singleton) ois.readObject();
        System.out.println(singleton2);
        System.out.println(singleton2.show());
    }
}
