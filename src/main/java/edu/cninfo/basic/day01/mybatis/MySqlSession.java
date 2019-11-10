package edu.cninfo.basic.day01.mybatis;

import edu.cninfo.basic.day01.mybatis.vo.Duck;
import edu.cninfo.basic.day01.mybatis.vo.Turkey;

import java.util.HashMap;
import java.util.Map;

public class MySqlSession {
    private static Map<String, Object> repository = new HashMap<>();

    static {
        repository.put("edu.cninfo.basic.day01.vo.DuckMapper.select", new Duck("duck1"));
        repository.put("edu.cninfo.basic.day01.vo.TurkeyMapper.select", new Turkey("turkey1"));
    }

    public Object select(String key) {
        System.out.println("key[" + key + "] 调用select方法");
        return repository.getOrDefault(key, null);
    }
}
