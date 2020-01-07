package edu.cninfo.concurrency.ch02.demo2;

public class Producer implements Runnable{
    private final EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.set();
        }
    }
}
