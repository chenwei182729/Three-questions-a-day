package edu.cninfo.basic.day01;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class SystemOutProxy {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Object object = Proxy.newProxyInstance(
                null,
                out.getClass().getInterfaces(),
                (Object proxy, Method m, Object[] margs) -> {
                    System.out.println(out + "." + m.getName() + Arrays.toString(margs));
                    return m.invoke(out, margs);
                }
        );
    }
}
