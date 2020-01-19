package edu.cninfo.basic.day10;

import java.util.concurrent.TimeUnit;

public class PhilosopherThread extends Thread {
    private Chopsticks chopsticks;

    public PhilosopherThread(String name, Chopsticks chopsticks) {
        super(name);
        this.chopsticks = chopsticks;
    }

    @Override
    public void run() {
        while (true) {
            chopsticks.getChop();
            Chopsticks.show();
            this.eat();
            chopsticks.freeChop();
        }
    }

    private void eat() {
        try {
            System.out.println(Thread.currentThread().getName() + " 进餐！");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
