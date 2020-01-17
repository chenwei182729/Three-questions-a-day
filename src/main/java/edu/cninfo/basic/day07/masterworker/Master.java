package edu.cninfo.basic.day07.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Master {
    private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
    private Map<String, Thread> workers = new HashMap<>();
    private Map<String, Object> resultMap = new ConcurrentHashMap<>();

    public Master(Worker worker, int workerCount) {
        worker.setTaskQueue(this.taskQueue);
        worker.setResultMap(this.resultMap);
        for (int i = 0; i < workerCount; i++) {
            this.workers.put(Integer.toString(i), new Thread(worker));
        }
    }

    public void submit(Task task) {
        this.taskQueue.add(task);
    }

    public void execute() {
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            entry.getValue().start();
        }
    }

    public int getResult() {
        int result = resultMap.values()
                .stream()
                .collect(Collectors.summingInt(v -> (Integer) v));
        return result;
    }

    public boolean isCompate() {
        return workers.values()
                .stream()
                .map(Thread::getState)
                .allMatch(state -> state == Thread.State.TERMINATED);
    }
}
