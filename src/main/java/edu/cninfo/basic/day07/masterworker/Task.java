package edu.cninfo.basic.day07.masterworker;

public class Task {
    private int id;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Task(int id, int count) {
        this.id = id;
        this.count = count;
    }
}
