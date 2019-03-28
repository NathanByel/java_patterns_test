package com.company;

public class Main {

    public static void main(String[] args) {
        DeviceManager deviceManager = DeviceManager.getInstance();

        deviceManager.addDevice("1");
        deviceManager.addDevice("2");

        boolean result = deviceManager.sendCommandToDevice("2", "open");
        System.out.println(result);

        result = deviceManager.sendCommandToDevice("10", "open");
        System.out.println(result);
    }
}
