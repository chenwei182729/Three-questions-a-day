package edu.cninfo.concurrency.ch01.threadfactory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory  implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        counter=0;
        this.name = name;
        stats=new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,name+"-Thread_"+counter);
        counter++;
        stats.add(String.format("Create thread %d with name %s on %s\n",t.getId(),t.getName(), Calendar.getInstance().getTime()));
        return t;
    }

    public String getStats(){
        return String.join("",stats);
    }

}
