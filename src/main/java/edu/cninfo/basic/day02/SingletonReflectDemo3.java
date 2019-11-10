package edu.cninfo.basic.day02;

import java.lang.reflect.Constructor;

/**
 * 反射对单例的破坏
 */
public class SingletonReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class<Singleton> singletonClass = Singleton.class;

        Constructor constr = singletonClass.getDeclaredConstructor(String.class,int.class);
        constr.setAccessible(true);
        Singleton singleton1 = (Singleton)constr.newInstance("helloworld", 1);
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton1.show());
        System.out.println(singleton2);
        System.out.println(singleton2.show());
    }
}
