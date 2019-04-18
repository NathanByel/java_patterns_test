package com.company;

import com.company.Command.Command;
import com.company.CommandWorker;

public class Device {

    public String devID;
    public String name;

    public Device() {
    }

    public Device(String devID, String name) {
        this.devID = devID;
        this.name = name;
    }

    public Device(String devID) {
        this.devID = devID;
        this.name = "";
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
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

    @Override
    public String toString() {
        return "Device{" +
                "devID='" + devID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
