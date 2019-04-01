package com.company;

import java.util.ArrayList;
import java.util.List;

public class CommandSequencer {
    private Device device;
    private List<Command> commandSequence;

    public CommandSequencer(Device device) {
        commandSequence = new ArrayList<>();
        this.device = device;
    }

    public void addCommand(Command command) {
        if (command == null) throw new IllegalArgumentException("Command can't be null");
        commandSequence.add(command);
    }

    public boolean sendAll() {
        boolean result = true;
        for (Command command : commandSequence) {
            result &= device.sendCommand(command);
        }
        return result;
    }
}
