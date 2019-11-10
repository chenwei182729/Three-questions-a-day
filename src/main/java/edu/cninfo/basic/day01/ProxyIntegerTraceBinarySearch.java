package edu.cninfo.basic.day01;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author chenxinwei
 * @date 2019-11-10
 */
public class ProxyIntegerTraceBinarySearch {
    public static void main(String[] args) {
        Object[] values = new Object[1000];
        for (int i = 0; i < 1000; i++) {
            Integer value = new Integer(i);
            values[i] = Proxy.newProxyInstance(
                    null,
                    value.getClass().getInterfaces(),
                    (Object proxy, Method m, Object[] margs) -> {
                        System.out.println(value + "." + m.getName() + Arrays.toString(margs));
                        return m.invoke(value, margs);
                    }
            );
        }
        Arrays.binarySearch(values, 500);
    }
}
