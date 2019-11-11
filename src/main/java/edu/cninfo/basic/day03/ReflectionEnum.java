package edu.cninfo.basic.day03;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author chenxinwei
 * @date 2019/11/7 9:11
 **/

public class ReflectionEnum {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("------Analyzing " + enumClass + " ---------");
        System.out.println("Interfaces:");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
    }
}
/**
------Analyzing class edu.cninfo.basic.day03.Explore ---------
        Interfaces:
        Base: class java.lang.Enum
        Methods:
        [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
        ------Analyzing class java.lang.Enum ---------
        Interfaces:
        java.lang.Comparable<E>
interface java.io.Serializable
        Base: class java.lang.Object
        Methods:
        [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
        Explore.containsAll(Enum)? true
        Explore.removeAll(Enum):
        [values]
**/