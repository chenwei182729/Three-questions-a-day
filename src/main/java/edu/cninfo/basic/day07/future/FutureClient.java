package edu.cninfo.basic.day07.future;

public class FutureClient {
    public Data request(final String queryStr) {

        FutureData futureData = new FutureData();

        new Thread(()->{
            /**
             * 需要把请求参数设置到真实的数据处理对象中去
             */
            RealData realData = new RealData(queryStr);
            /**
             * 真实请求处理完成以后，我进行设置结果到包装类对象
             */
            futureData.setRealData(realData);
        }).start();
        return futureData;
    }
}
