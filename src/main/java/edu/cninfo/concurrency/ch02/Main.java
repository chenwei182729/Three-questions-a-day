package edu.cninfo.concurrency.ch02;

public class Main {
    public static void main(String[] args) {
        ParkingCash parkingCash = new ParkingCash();
        ParkingStats parkingStats = new ParkingStats(parkingCash);
        System.out.printf("Parking Simulator\n");
        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread threads[] = new Thread[numberSensors];

        for (int i = 0; i < numberSensors; i++) {
            Sensor sensor = new Sensor(parkingStats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of caars :%d\n", parkingStats.getNumberCars());
        System.out.printf("Number of caars :%d\n", parkingStats.getNumberMotorcycles());
        parkingCash.close();
    }
}
