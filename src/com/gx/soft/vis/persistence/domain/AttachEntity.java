package com.gx.soft.vis.persistence.domain;


import java.sql.Timestamp;

public class AttachEntity {
    private String scRowId;
    private String scTextName;
    private Timestamp scTime;
    private String scUser;
    private String scCz;

    public String getScRowId() {
        return scRowId;
    }

    public void setScRowId(String scRowId) {
        this.scRowId = scRowId;
    }

    public String getScTextName() {
        return scTextName;
    }

    public void setScTextName(String scTextName) {
        this.scTextName = scTextName;
    }

    public Timestamp getScTime() {
        return scTime;
    }

    public void setScTime(Timestamp scTime) {
        this.scTime = scTime;
    }

    public String getScUser() {
        return scUser;
    }

    public void setScUser(String scUser) {
        this.scUser = scUser;
    }

    public String getScCz() {
        return scCz;
    }

    public void setScCz(String scCz) {
        this.scCz = scCz;
    }
}
