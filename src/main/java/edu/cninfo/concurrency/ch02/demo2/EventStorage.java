package edu.cninfo.concurrency.ch02.demo2;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {
    private final int maxSize;
    private Queue<Date> storage;

    public EventStorage() {
        maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Date date = storage.poll();
        System.out.println("Get: " + date);
        notify();
    }

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(Calendar.getInstance().getTime());
        notify();
    }
}
