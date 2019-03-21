package com.company;

import java.util.Date;

public abstract class Command {
    private final Date timestapm = new Date();
    private String devID;

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public Date getTimestapm() {
        return timestapm;
    }
}
