package edu.cninfo.concurrency.ch01;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class ConsoleClock implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n",new Date());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has bean interrupted");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleClock consoleClock = new ConsoleClock();
        Thread task = new Thread(consoleClock);
        task.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
