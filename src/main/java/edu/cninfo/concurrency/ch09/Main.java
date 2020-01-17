package edu.cninfo.concurrency.ch09;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();

        Thread[] thraeds = new Thread[5];
        for (int i = 0; i < 5; i++) {
            Task task = new Task(myLock);
            thraeds[i] = new Thread(task);
            thraeds[i].start();
        }

        for (int i = 0; i < 15; i++) {
            System.out.println("Main: Logging the Lock");
            System.out.println("***********************");
            System.out.println("Lock: Owner:"+myLock.getOwnerName());
            System.out.println("Lock: Queued Threads:"+ myLock.hasQueuedThreads());

            if(myLock.hasQueuedThreads()){
                System.out.println("Lock: Queue Length" + myLock.getQueueLength());
                System.out.println("Lock: Queued Threads:");
                Collection<Thread> threads = myLock.getThreads();

                for (Thread thraed : thraeds) {
                    System.out.print(thraed.getName()+" ");
                }
                System.out.println();
            }
            System.out.println("Lock: Fairness:" + myLock.isFair());
            System.out.println("Lock: locked:" + myLock.isLocked());
            System.out.println("***********************");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
