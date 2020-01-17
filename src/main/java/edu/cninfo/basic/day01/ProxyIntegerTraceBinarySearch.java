package edu.cninfo.basic.day01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author chenxinwei
 * @date 2019-11-10
 */
public class ProxyIntegerTraceBinarySearch {
    public static void main(String[] args) {
        Comparable[] values = new Comparable[1000];
        for (int i = 0; i < 1000; i++) {
            Integer value = new Integer(i);
            values[i] = (Comparable) Proxy.newProxyInstance(
                    null,
                    value.getClass().getInterfaces(),
                    new MyInvocationHandler(value)
//                    (Object proxy, Method m, Object[] margs) -> {
//                        System.out.println(value + "." + m.getName() + Arrays.toString(margs));
//                        return m.invoke(value, margs);
//                    }
            );
        }
        Arrays.binarySearch(values, 500);
    }

    private static class MyInvocationHandler implements InvocationHandler {
        private final Integer value;

        public MyInvocationHandler(Integer value) {
            this.value = value;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println(value + "." + method.getName() + Arrays.toString(args));
            return method.invoke(value, args);
        }
    }
}
