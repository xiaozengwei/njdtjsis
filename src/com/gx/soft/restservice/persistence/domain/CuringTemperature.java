package com.gx.soft.restservice.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/20.
 */
@Entity
@Table(name = "curing_temperature", schema = "njdtjsis", catalog = "")
public class CuringTemperature {
    private String bdId;
    private String temperatureOrder;
    private String humidityOrder;
    private String temperature;
    private String humidity;
    private Timestamp time;
    private String rowId;

    @Basic
    @Column(name = "bdId")
    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    @Basic
    @Column(name = "temperatureOrder")
    public String getTemperatureOrder() {
        return temperatureOrder;
    }

    public void setTemperatureOrder(String temperatureOrder) {
        this.temperatureOrder = temperatureOrder;
    }

    @Basic
    @Column(name = "humidityOrder")
    public String getHumidityOrder() {
        return humidityOrder;
    }

    public void setHumidityOrder(String humidityOrder) {
        this.humidityOrder = humidityOrder;
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
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Id
    @Column(name = "rowId")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuringTemperature that = (CuringTemperature) o;

        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (temperatureOrder != null ? !temperatureOrder.equals(that.temperatureOrder) : that.temperatureOrder != null)
            return false;
        if (humidityOrder != null ? !humidityOrder.equals(that.humidityOrder) : that.humidityOrder != null)
            return false;
        if (temperature != null ? !temperature.equals(that.temperature) : that.temperature != null) return false;
        if (humidity != null ? !humidity.equals(that.humidity) : that.humidity != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bdId != null ? bdId.hashCode() : 0;
        result = 31 * result + (temperatureOrder != null ? temperatureOrder.hashCode() : 0);
        result = 31 * result + (humidityOrder != null ? humidityOrder.hashCode() : 0);
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (rowId != null ? rowId.hashCode() : 0);
        return result;
    }
}
