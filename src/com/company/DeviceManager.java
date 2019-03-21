package com.company;

import java.util.ArrayList;
import java.util.List;

public class DeviceManager {
    private static final DeviceManager deviceManager = new DeviceManager();
    private List<Device> devices = new ArrayList<>();

    private DeviceManager() {
    }

    public static DeviceManager getInstance() {
        return deviceManager;
    }

    public void addDevice(String devID) {
        devices.add(new Device(devID));
    }

    public boolean sendCommandToDevice(String devID, String command) {
        Command commandToSend = CommandFactory.getCommand(command);
        if(commandToSend == null) return false;

        Device device = findByID(devID);
        if(device == null) return false;

        return device.sendCommand(commandToSend);
    }

    public Device findByID(String devID) {
        for (Device device : devices) {
            if(device.getDevID().equals(devID)) {
                return device;
            }
        }
        return null;
    }
}
