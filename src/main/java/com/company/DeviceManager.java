package com.company;

import com.company.Command.Command;
import com.company.Command.CommandFactory;

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

    public void sendCommandToDevice(String devID, String command) throws Exception {
        Command commandToSend = CommandFactory.getCommand(command);
        if (commandToSend == null) {
            throw new IllegalArgumentException("Command \"" + command + "\" not found");
        }

        Device device = findByID(devID);
        if (device == null) {
            throw new IllegalArgumentException("Device \"" + devID + "\" not found");
        }

        if (!device.sendCommand(commandToSend)) {
            throw new Exception("Failed to send command");
        }
    }

    public boolean sendCommandSequenceToDevice(String devID, String... commands) {
        Device device = findByID(devID);
        if (device == null) return false;

        CommandSequencer commandSequencer = new CommandSequencer(device);
        for (String command : commands) {
            Command commandToSend = CommandFactory.getCommand(command);
            if (commandToSend == null) return false;

            commandSequencer.addCommand(commandToSend);
        }

        return commandSequencer.sendAll();
    }

    public Device findByID(String devID) {
        for (Device device : devices) {
            if (device.getDevID().equals(devID)) {
                return device;
            }
        }
        return null;
    }
}
