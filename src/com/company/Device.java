package com.company;

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
        // netsend(command);

        System.out.println("Command \"" + command.getClass().getSimpleName() + "\" was sent");
        return true;
    }
}
