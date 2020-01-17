package edu.cninfo.concurrency.ch02.demo2;

public class Main {
    public static void main(String[] args) {
        final EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Thread thread1 = new Thread(producer);

        final Consumer consumer = new Consumer(eventStorage);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}
