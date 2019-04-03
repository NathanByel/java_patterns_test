package com.company.Command;

import com.company.ConsoleColors;

import java.util.Date;

public abstract class AbstractCommand implements Command {
    private final Date timestapm = new Date();
    private String devID;

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public Date getTimestapm() {
        return timestapm;
    }

    public void toLog() {
        System.out.printf("%s%s: Command \"%s\"(Time stamp %s) to device \"%s\" was executed.%s\n",
                ConsoleColors.ANSI_YELLOW,
                new Date(),
                getClass().getSimpleName(),
                getTimestapm(),
                getDevID(),
                ConsoleColors.ANSI_RESET);
    }
}
