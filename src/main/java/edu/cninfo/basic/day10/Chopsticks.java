package edu.cninfo.basic.day10;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Chopsticks {
    private static List<Chops> chops = new ArrayList<>();
    private static Map<String, Boolean> philosopherMap = new ConcurrentHashMap<>();

    public static void init(int count) {
        for (int i = 0; i < count; i++) {
            chops.add(new Chops.Builder().name(i).isUsed(false).build());
        }
    }

    public synchronized void getChop() {
        String currentName = Thread.currentThread().getName();
        if (philosopherMap.containsKey(currentName)) {
            Thread.currentThread().stop();
        }
        int left = Integer.parseInt(currentName);
        int right = (left + 1) % 5;

        while (chops.get(left).isUsed() || chops.get(right).isUsed()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        philosopherMap.put(currentName,true);
        chops.set(left, new Chops.Builder().name(left).isUsed(true).build());
        chops.set(right, new Chops.Builder().name(right).isUsed(true).build());
    }

    public synchronized void freeChop() {
        String currentName = Thread.currentThread().getName();
        int left = Integer.parseInt(currentName);
        int right = (left + 1) % 5;

        chops.set(left, new Chops.Builder().name(left).build());
        chops.set(right, new Chops.Builder().name(right).build());
        notifyAll();
    }

    public static void show() {
        chops.stream()
                .forEach(System.out::println);
    }
}
