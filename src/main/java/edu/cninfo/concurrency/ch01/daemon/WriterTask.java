package edu.cninfo.concurrency.ch01.daemon;

import java.util.Calendar;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable{

    private final Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(Calendar.getInstance().getTime());
            event.setEvent(String.format("The thread %s has generated the event %d event",Thread.currentThread().getId(),i));
            deque.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
