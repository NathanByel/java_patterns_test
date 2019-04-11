package com.company.domain;

import javax.persistence.*;

@Entity
@Cacheable
@Table(name = "devices")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String devID;
    private String name;

    public DeviceEntity() {
    }

    public DeviceEntity(String devID, String name) {
        this.devID = devID;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
