package com.company;

import com.company.Command.Command;

import java.util.concurrent.LinkedBlockingQueue;

public class CommandWorker {
    private static CommandWorker commandWorker = new CommandWorker();
    private LinkedBlockingQueue<Command> commandQueue = new LinkedBlockingQueue<>();

    private CommandWorker() {
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(ConsoleColors.ANSI_BLUE +
                            "CommandWorker waiting the next command..."
                            + ConsoleColors.ANSI_RESET);
                    Command command = commandQueue.take();
                    command.execute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static CommandWorker getInstance() {
        return commandWorker;
    }

    public void addCommand(Command command) {
        commandQueue.offer(command);
    }
}
