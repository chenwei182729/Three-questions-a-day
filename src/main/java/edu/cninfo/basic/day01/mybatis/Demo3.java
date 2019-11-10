package edu.cninfo.basic.day01.mybatis;

import edu.cninfo.basic.day01.mybatis.mapper.DuckMapper;
import edu.cninfo.basic.day01.mybatis.vo.Duck;

import java.lang.reflect.Proxy;

public class Demo3 {
    public static void main(String[] args) {

        MySqlSession mySqlSession = new MySqlSession();
        MyMapperProxy duckProxy = new MyMapperProxy(
                DuckMapper.class,
                mySqlSession
        );

        DuckMapper duckMapper = (DuckMapper) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{DuckMapper.class},
                duckProxy
        );

        final Duck duck = duckMapper.select();
        System.out.println(duck);
    }
}
