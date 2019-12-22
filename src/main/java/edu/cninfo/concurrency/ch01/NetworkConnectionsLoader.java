package edu.cninfo.concurrency.ch01;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading:%s\n", Calendar.getInstance().getTime());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data sources loading has finished: %s\n", Calendar.getInstance().getTime());
    }
}
