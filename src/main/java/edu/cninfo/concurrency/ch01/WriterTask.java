package edu.cninfo.concurrency.ch01;


import edu.cninfo.concurrency.ch01.vo.Event;

import java.util.Calendar;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {
    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event(Calendar.getInstance().getTime(),
                    String.format("The thread %s has generate an event", Thread.currentThread().getId()));
            deque.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Deque<Event> deque = new ConcurrentLinkedDeque<>();
        WriterTask writerTask = new WriterTask(deque);
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }
        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
