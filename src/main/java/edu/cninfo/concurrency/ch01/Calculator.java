package edu.cninfo.concurrency.ch01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public final class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0L;
        System.out.printf("Thread '%s': START\n", Thread.currentThread().getName());

        while (current <= max) {
            if (PrimeUtil.isPrime(current)) {
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s': END. Number of Primes: %d\n", Thread.currentThread().getName(), numPrimes);
    }


    public static void main(String[] args) {
        System.out.printf("Minimum Priority : %s\n", Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority : %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority : %s\n", Thread.MAX_PRIORITY);

        List<Thread> threads = new ArrayList<>(20);
        List<Thread.State> states = new ArrayList<>(20);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Calculator());

            if ((i % 2) == 0) {
                thread.setPriority(Thread.MAX_PRIORITY);
            } else {
                thread.setPriority(Thread.MIN_PRIORITY);
            }
            thread.setName("My Thread " + i);
            threads.add(thread);
        }


        try (FileWriter fileWriter = new FileWriter(".\\data\\log.txt");
             PrintWriter pw = new PrintWriter(fileWriter)) {
            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads.get(i).getState());
                states.add(threads.get(i).getState());
            }


            for (int i = 0; i < 10; i++) {
                threads.get(i).start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads.get(i).getState() != states.get(i)) {
                        writeThreadInfo(pw, threads.get(i), states.get(i));
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && threads.get(i).getState() == Thread.State.TERMINATED;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State %s\n", state);
        pw.printf("Main : New State %s\n", thread.getState());
        pw.printf("Main : *******************************************\n");
    }
}
