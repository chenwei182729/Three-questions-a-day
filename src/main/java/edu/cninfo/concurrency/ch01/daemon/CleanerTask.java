package edu.cninfo.concurrency.ch01.daemon;

import java.util.Calendar;
import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {
    private static final long DIFFERENCE_CONST = 10000;
    private final Deque<Event2> deque;

    public CleanerTask(Deque<Event2> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = Calendar.getInstance().getTime();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        if (deque.size() == 0) {
            return;
        }

        boolean delete = false;

        do {
            Event2 event = deque.getLast();
            difference = date.getTime() - event.getDate().getTime();
            if (difference > DIFFERENCE_CONST) {
                System.out.println("Cleaner : " + event.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (difference > DIFFERENCE_CONST);
        if (delete) {
            System.out.println("Cleaner : Size of the queue : " + deque.size());
        }
    }
}
