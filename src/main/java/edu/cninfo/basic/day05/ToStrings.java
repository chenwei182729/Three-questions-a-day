package edu.cninfo.basic.day05;

import edu.cninfo.basic.day05.vo.Point;
import edu.cninfo.basic.day05.vo.Rectangle;

import java.lang.reflect.Field;

public class ToStrings {
    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        Class<?> cl = obj.getClass();
        ToString ts = cl.getAnnotation(ToString.class);
        if (ts == null) {
            return obj.toString();
        }
        StringBuilder result = new StringBuilder();
        if (ts.includeName()) {
            result.append(cl.getName());
        }
        result.append("[");
        boolean first = true;

        for (Field f : cl.getDeclaredFields()) {
            ts = f.getAnnotation(ToString.class);
            if (ts != null) {
                if (first) {
                    first = false;
                } else {
                    result.append(",");
                }
                f.setAccessible(true);
                if (ts.includeName()) {
                    result.append(f.getName());
                    result.append("=");
                }
                try {
                    result.append(ToStrings.toString(f.get(obj)));
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        }
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Rectangle r = new Rectangle(p, 10, 20);
        System.out.println(toString(p));
        System.out.println(toString(r));
    }
}
//Result:
// [[1,2],10,20]