package com.gx.soft.mobile.persistence.vo;

public class WlCountVo {

    private String dicName;
    private String dicTotal;
    private String danWei;

    public String getDanWei() {
        return danWei;
    }

    public void setDanWei(String danWei) {
        this.danWei = danWei;
    }

    public WlCountVo() {
    }

    public WlCountVo(String dicName, String dicTotal) {
        this.dicName = dicName;
        this.dicTotal = dicTotal;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public String getDicTotal() {
        return dicTotal;
    }

    public void setDicTotal(String dicTotal) {
        this.dicTotal = dicTotal;
    }
}
