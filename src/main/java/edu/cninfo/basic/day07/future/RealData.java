package edu.cninfo.basic.day07.future;

import java.util.concurrent.TimeUnit;

public class RealData implements Data {
    private String result;

    public RealData(String queryStr) {
        System.out.println("根据查询参数：" + queryStr + "进行查询数据库操作，可能需要5s左右...");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = "查询结果：100条数据";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
