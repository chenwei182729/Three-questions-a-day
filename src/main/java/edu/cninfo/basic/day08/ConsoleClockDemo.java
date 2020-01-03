package edu.cninfo.basic.day08;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ConsoleClockDemo {

    public static void main(String[] args) {
        final ConsoleClock consoleClock = new ConsoleClock();
        Thread thread = new Thread(consoleClock);

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }

    static class ConsoleClock implements Runnable  {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Calendar.getInstance().getTime());

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println("The FileClock has bean interrupted.");
                }
            }
        }

    }
}
