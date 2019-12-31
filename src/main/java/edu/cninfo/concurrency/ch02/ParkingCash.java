package edu.cninfo.concurrency.ch02;

public class ParkingCash {
    private static final long cost = 2;
    private long cach;

    public synchronized void vehiclePly() {
        cach += cost;
    }

    public void close() {
        System.out.println("Closing accounting");
        long totalAmount=0;
        synchronized (this) {
            totalAmount = cach;
            cach = 0;
        }
        System.out.printf("The totalAmount is :%d", totalAmount);
    }
}
