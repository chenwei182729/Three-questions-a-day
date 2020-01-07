package edu.cninfo.concurrency.ch02.demo1;

public class ParkingStats {
    private long numberCars;
    private long numberMotorCycles;
    private ParkingCash cash;
    private Object controlCars = new Object();

    public ParkingStats(ParkingCash parkingCash) {
        numberCars = 0;
        numberMotorCycles = 0;
        this.cash = parkingCash;
    }

    public synchronized void carComeIn() {
        numberCars++;
    }

    public void carGoOut() {
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePly();
    }

    public synchronized void motorComeIn() {
        numberCars++;
    }

    public void motorGoOut() {
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePly();
    }

    public long getNumberCars() {
        return numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorCycles;
    }
}
