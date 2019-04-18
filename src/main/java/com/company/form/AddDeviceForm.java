package com.company.form;

import javax.validation.constraints.Size;

public class AddDeviceForm {

    @Size(min=1, max=35)
    private String devID;

    @Size(min=1, max= 20)
    private String name;

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
