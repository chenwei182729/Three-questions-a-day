package edu.cninfo.basic.day10;

import java.util.ArrayList;
import java.util.List;

public class PhilosopherTest {
    private static int PEOPLE_COUNT = 10;

    public static void main(String[] args) {

        Chopsticks chopsticks = new Chopsticks();
        List<Thread> threads = new ArrayList<>();

        PhilosopherThread philosopherThread;
        for (int i = 0; i < PEOPLE_COUNT; i++) {
            philosopherThread = new PhilosopherThread(Integer.toString(i), chopsticks);
            threads.add(philosopherThread);
        }
        Chopsticks.init(PEOPLE_COUNT);

        threads.forEach(Thread::start);

    }
}
