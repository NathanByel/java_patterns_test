package com.company;

import com.company.Command.Command;

public class Device {
    private String devID;
    private String name;

    public Device(String devID) {
        this.devID = devID;
    }

    public String getDevID() {
        return devID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean sendCommand(Command command) {
        command.setDevID(devID);
        CommandWorker.getInstance().addCommand(command);
        return true;
    }
}
