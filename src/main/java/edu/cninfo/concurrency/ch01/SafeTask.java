package edu.cninfo.concurrency.ch01;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
    private ThreadLocal<Date> startDate=new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return Calendar.getInstance().getTime();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),startDate.get());

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),startDate.get());
    }

    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
