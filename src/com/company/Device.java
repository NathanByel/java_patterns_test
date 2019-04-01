package com.company;

import com.company.Command.Command;

public class Device {
    private String devID;

    public Device(String devID) {
        this.devID = devID;
    }

    public String getDevID() {
        return devID;
    }

    public boolean sendCommand(Command command) {
        command.setDevID(devID);
        CommandWorker.getInstance().addCommand(command);
        return true;
    }
}
