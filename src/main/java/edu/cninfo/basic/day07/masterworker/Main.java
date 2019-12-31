package edu.cninfo.basic.day07.masterworker;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        Master master = new Master(worker, availableProcessors);

        for (int i = 0; i < 100; i++) {
            master.submit(new Task(i, ThreadLocalRandom.current().nextInt(10)));
        }
        master.execute();

        long start = System.currentTimeMillis();
        while (true) {
            if (master.isCompate()) {
                long end = System.currentTimeMillis();
                int result = master.getResult();

                System.out.println("运行完成：" + result + ",总耗时：" + (end - start));
                break;
            }
        }
    }
}
