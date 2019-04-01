package com.company;

public class Main {

    public static void main(String[] args) {
        DeviceManager deviceManager = DeviceManager.getInstance();

        deviceManager.addDevice("1");
        deviceManager.addDevice("2");

        try {
            deviceManager.sendCommandToDevice("2", "open");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            deviceManager.sendCommandToDevice("10", "open");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            deviceManager.sendCommandToDevice("1", "close");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //result = deviceManager.sendCommandSequenceToDevice("2", "close", "block");
        //System.out.println(result);
    }
}
