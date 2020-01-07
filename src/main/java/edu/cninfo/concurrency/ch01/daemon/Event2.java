package edu.cninfo.concurrency.ch01.daemon;


import java.util.Date;

public class Event2 {
    private Date date;
    private String event;

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", event='" + event + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
