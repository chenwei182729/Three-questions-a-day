package edu.cninfo.basic.day01.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy<T> implements InvocationHandler {
    private Class<T> mapperInterface;
    private MySqlSession mySqlSession;

    public MyMapperProxy(Class<T> mapperInterface, MySqlSession mySqlSession) {
        this.mapperInterface = mapperInterface;
        this.mySqlSession = mySqlSession;
    }

    /**
     * 将class的select方法绑定到mySqlSession.select方法上
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = mySqlSession.select(mapperInterface.getCanonicalName() + "." + method.getName());
        return res;
    }
}
