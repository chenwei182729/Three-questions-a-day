package edu.cninfo.concurrency.ch01;

public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an Exception\n", t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }

    public static void main(String[] args) {
        int numberOfThread = 2 * Runtime.getRuntime().availableProcessors();
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyTheadGroup");
        Task2 task = new Task2();
        for (int i = 0; i < numberOfThread; i++) {
            Thread t=new Thread(myThreadGroup,task);
            t.start();
        }


        System.out.printf( "Number of Threads : %d\n",myThreadGroup.activeCount());
        System.out.printf( "Information about the Thread Group\n");
        myThreadGroup.list();

        Thread[] threads = new Thread[myThreadGroup.activeCount()];
        myThreadGroup.enumerate(threads);
        for (int i = 0; i < myThreadGroup.activeCount(); i++) {
            System.out.printf("Thread %s : %s \n",threads[i].getName(),threads[i].getState());
        }
    }
}
