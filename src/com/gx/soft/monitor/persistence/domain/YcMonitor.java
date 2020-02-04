package com.gx.soft.monitor.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "yc_monitor", schema = "njdtjsis", catalog = "")
public class YcMonitor {
    private String rowId;
    private String bdId;
    private String bdName;
    private String orderAll;
    private String pm25;
    private String pm10;
    private String db;
    private String temperature;
    private String humidity;
    private String wind;
    private String speed;
    private String time;
    private String localRecordTime;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "rowId")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "bdId")
    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    @Basic
    @Column(name = "bdName")
    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    @Basic
    @Column(name = "orderAll")
    public String getOrderAll() {
        return orderAll;
    }

    public void setOrderAll(String orderAll) {
        this.orderAll = orderAll;
    }

    @Basic
    @Column(name = "pm25")
    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    @Basic
    @Column(name = "pm10")
    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    @Basic
    @Column(name = "db")
    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Basic
    @Column(name = "temperature")
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Basic
    @Column(name = "humidity")
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Basic
    @Column(name = "wind")
    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Basic
    @Column(name = "speed")
    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "localRecordTime")
    public String getLocalRecordTime() {
        return localRecordTime;
    }

    public void setLocalRecordTime(String localRecordTime) {
        this.localRecordTime = localRecordTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YcMonitor ycMonitor = (YcMonitor) o;

        if (rowId != null ? !rowId.equals(ycMonitor.rowId) : ycMonitor.rowId != null) return false;
        if (bdId != null ? !bdId.equals(ycMonitor.bdId) : ycMonitor.bdId != null) return false;
        if (bdName != null ? !bdName.equals(ycMonitor.bdName) : ycMonitor.bdName != null) return false;
        if (orderAll != null ? !orderAll.equals(ycMonitor.orderAll) : ycMonitor.orderAll != null) return false;
        if (pm25 != null ? !pm25.equals(ycMonitor.pm25) : ycMonitor.pm25 != null) return false;
        if (pm10 != null ? !pm10.equals(ycMonitor.pm10) : ycMonitor.pm10 != null) return false;
        if (db != null ? !db.equals(ycMonitor.db) : ycMonitor.db != null) return false;
        if (temperature != null ? !temperature.equals(ycMonitor.temperature) : ycMonitor.temperature != null)
            return false;
        if (humidity != null ? !humidity.equals(ycMonitor.humidity) : ycMonitor.humidity != null) return false;
        if (wind != null ? !wind.equals(ycMonitor.wind) : ycMonitor.wind != null) return false;
        if (speed != null ? !speed.equals(ycMonitor.speed) : ycMonitor.speed != null) return false;
        if (time != null ? !time.equals(ycMonitor.time) : ycMonitor.time != null) return false;
        if (localRecordTime != null ? !localRecordTime.equals(ycMonitor.localRecordTime) : ycMonitor.localRecordTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (orderAll != null ? orderAll.hashCode() : 0);
        result = 31 * result + (pm25 != null ? pm25.hashCode() : 0);
        result = 31 * result + (pm10 != null ? pm10.hashCode() : 0);
        result = 31 * result + (db != null ? db.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (wind != null ? wind.hashCode() : 0);
        result = 31 * result + (speed != null ? speed.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (localRecordTime != null ? localRecordTime.hashCode() : 0);
        return result;
    }
}
