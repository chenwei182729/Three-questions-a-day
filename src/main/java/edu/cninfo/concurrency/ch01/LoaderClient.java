package edu.cninfo.concurrency.ch01;

import java.util.Calendar;

public class LoaderClient {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DataSourcesLoader(), "DataSourceThread");
        Thread t2 = new Thread(new NetworkConnectionsLoader(), "NetworkConnectionLoader");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Configuration has bean loaded : %s\n", Calendar.getInstance().getTime());

    }
}
