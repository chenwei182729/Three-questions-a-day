package edu.cninfo.basic.day01;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonProxy {
    private static Logger logger = Logger.getGlobal();

    static {
        logger.setLevel(Level.INFO);
    }

    public static void main(String[] args) {
        Person person = new Person(10, "chenxinwei", "henan");
        Object personProxy = Proxy.newProxyInstance(
                null,
                person.getClass().getInterfaces(),
                (Object proxy, Method m, Object[] margs) -> {
                    logger.info("invoke Method: " + person + "." + m.getName() + Arrays.toString(margs));
                    return m.invoke(person, margs);
                }
        );
        logger.info(personProxy.toString());
    }
}
