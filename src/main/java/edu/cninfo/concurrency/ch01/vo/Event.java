package edu.cninfo.concurrency.ch01.vo;

import java.util.Date;

public class Event {
    private Date date;
    private String event;

    public Event(Date date, String event) {
        this.date = date;
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }
}
