package edu.cninfo.basic.day07.future;

public class Main {
    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data data = futureClient.request("请求参数...");

        System.out.println("做其他的相关业务操作");
        String ret = data.getRequest();
        System.out.println("-------" + ret);
    }
}
