package edu.cninfo.concurrency.ch01;

import java.sql.Time;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class UseThreadJoin {

    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println("Begining data sources loading : " + Calendar.getInstance().getTime());

            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Data sources loading has finished : " + Calendar.getInstance().getTime());
        };

        Runnable r2 = () -> {
            System.out.println("Begining network connections loading : " + Calendar.getInstance().getTime());

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Networking connections loading has finished : " + Calendar.getInstance().getTime());
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();


        try {
            t1.join();/**等待t1执行完成*/
            TimeUnit.SECONDS.sleep(5);
            t2.join();/**等待t2执行完成*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }
}
