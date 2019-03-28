package com.company;

public class Main {

    public static void main(String[] args) {
        DeviceManager deviceManager = DeviceManager.getInstance();

        deviceManager.addDevice("1");
        deviceManager.addDevice("2");

        boolean result = deviceManager.sendCommandToDevice("2", "open");
        System.out.println(result);
        System.out.println();

        result = deviceManager.sendCommandToDevice("10", "open");
        System.out.println(result);
        System.out.println();
        
        result = deviceManager.sendCommandSequenceToDevice("2", "close", "block");
        System.out.println(result);
    }
}
