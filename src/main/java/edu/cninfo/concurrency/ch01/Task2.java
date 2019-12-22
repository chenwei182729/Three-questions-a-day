package edu.cninfo.concurrency.ch01;

import java.util.Random;

public class Task2 implements Runnable{
    @Override
    public void run() {
        int result ;
        Random random = new Random(Thread.currentThread().getId());
        while (true){
            result = 1000/((int)(random.nextDouble()*1000000000));
            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
            }
            return;
        }
    }
}
