package com.company.Command;

import java.util.Date;

public interface Command {
    void execute();

    String getDevID();

    void setDevID(String devID);

    Date getTimestapm();
}
