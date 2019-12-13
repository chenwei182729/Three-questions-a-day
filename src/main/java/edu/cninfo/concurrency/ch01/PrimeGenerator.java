package edu.cninfo.concurrency.ch01;

public final class PrimeGenerator extends Thread {
    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (PrimeUtil.isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            if (isInterrupted()) {
                System.out.printf("", "The Prime Generator has bean Interrupted");
                return;
            }
            number++;
        }
    }

    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();

        System.out.printf("Main: Status of Thread: %s\n", task.getState());
        System.out.printf("Main: isInterrupted: %s\n", task.isInterrupted());
        System.out.printf("Main: isAlive: %s\n", task.isAlive());
    }
}
