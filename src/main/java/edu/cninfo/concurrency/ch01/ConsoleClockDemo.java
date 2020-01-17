package edu.cninfo.concurrency.ch01;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ConsoleClockDemo {

    public static void main(String[] args) {
        final ConsoleClock consoleClock = new ConsoleClock();
        Thread thread = new Thread(consoleClock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            thread.interrupt();
        }

    }

    static class ConsoleClock implements Runnable {
        @Override
        public void run() {
            while(true){
                System.out.println(Calendar.getInstance().getTime());
                if (Thread.interrupted()) {
                    System.out.println("==================Thread interrupted============");
                    break;
                }
            }
//            for (int i = 0; i < 10; i++) {
//                if (Thread.interrupted()) {
//                    System.out.println("==================Thread interrupted============");
//                    break;
//                }
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
////                    e.printStackTrace();
//                    System.out.println("The FileClock has bean interrupted.");
//                }
//
//            }
        }

    }
}
