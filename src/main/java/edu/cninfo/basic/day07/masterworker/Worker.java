package edu.cninfo.basic.day07.masterworker;

import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {
    private ConcurrentLinkedQueue<Task> taskQueue;
    private Map<String, Object> resultMap;

    public void setTaskQueue(ConcurrentLinkedQueue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        while (true) {
            final Task task = taskQueue.poll();
            if (task == null) {
                break;
            }
            final Object result = handle(task);
            this.resultMap.put(Integer.toString(task.getId()), result);
        }
    }

    private Object handle(Task task) {
        try {
            TimeUnit.MILLISECONDS.sleep(20 * ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int count = task.getCount();
        return count;
    }
}
