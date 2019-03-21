package com.company;

public class CommandFactory {
    public static Command getCommand(String command) {
        if(command.equalsIgnoreCase("open")) {
            return new CommandOpen();
        } else if(command.equalsIgnoreCase("close")) {
            return new CommandClose();
        } else if(command.equalsIgnoreCase("block")) {
            return new CommandBlock();
        }
        return null;
    }
}
