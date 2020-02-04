package com.gx.soft.mobile.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/11.
 */
@Entity
@Table(name = "by_project_introduction", schema = "njdtjsis", catalog = "")
public class ByProjectIntroduction {
    private String rowId;
    private String stationTotalProject;
    private String qjtjTotalGcs;
    private String fgTotalSchedule;
    private String sbTotalSchedule;
    private String tzwcMoney;
    private Integer stationAllCount;
    private Integer ykgStationAllCount;
    private Integer dgjAllCount;
    private Integer ysfDgjCount;
    private String projectIntroduction;
    private String stationTotalProject02;
    private Timestamp createTime;
    private Timestamp updateTime;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "row_id", unique = true, nullable = false, length = 40)
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "station_total_project")
    public String getStationTotalProject() {
        return stationTotalProject;
    }

    public void setStationTotalProject(String stationTotalProject) {
        this.stationTotalProject = stationTotalProject;
    }

    @Basic
    @Column(name = "qjtj_total_gcs")
    public String getQjtjTotalGcs() {
        return qjtjTotalGcs;
    }

    public void setQjtjTotalGcs(String qjtjTotalGcs) {
        this.qjtjTotalGcs = qjtjTotalGcs;
    }

    @Basic
    @Column(name = "fg_total_schedule")
    public String getFgTotalSchedule() {
        return fgTotalSchedule;
    }

    public void setFgTotalSchedule(String fgTotalSchedule) {
        this.fgTotalSchedule = fgTotalSchedule;
    }

    @Basic
    @Column(name = "sb_total_schedule")
    public String getSbTotalSchedule() {
        return sbTotalSchedule;
    }

    public void setSbTotalSchedule(String sbTotalSchedule) {
        this.sbTotalSchedule = sbTotalSchedule;
    }

    @Basic
    @Column(name = "tzwc_money")
    public String getTzwcMoney() {
        return tzwcMoney;
    }

    public void setTzwcMoney(String tzwcMoney) {
        this.tzwcMoney = tzwcMoney;
    }

    @Basic
    @Column(name = "station_all_count")
    public Integer getStationAllCount() {
        return stationAllCount;
    }

    public void setStationAllCount(Integer stationAllCount) {
        this.stationAllCount = stationAllCount;
    }

    @Basic
    @Column(name = "ykg_station_all_count")
    public Integer getYkgStationAllCount() {
        return ykgStationAllCount;
    }

    public void setYkgStationAllCount(Integer ykgStationAllCount) {
        this.ykgStationAllCount = ykgStationAllCount;
    }

    @Basic
    @Column(name = "dgj_all_count")
    public Integer getDgjAllCount() {
        return dgjAllCount;
    }

    public void setDgjAllCount(Integer dgjAllCount) {
        this.dgjAllCount = dgjAllCount;
    }

    @Basic
    @Column(name = "ysf_dgj_count")
    public Integer getYsfDgjCount() {
        return ysfDgjCount;
    }

    public void setYsfDgjCount(Integer ysfDgjCount) {
        this.ysfDgjCount = ysfDgjCount;
    }

    @Basic
    @Column(name = "project_introduction")
    public String getProjectIntroduction() {
        return projectIntroduction;
    }

    public void setProjectIntroduction(String projectIntroduction) {
        this.projectIntroduction = projectIntroduction;
    }

    @Basic
    @Column(name = "station_total_project02")
    public String getStationTotalProject02() {
        return stationTotalProject02;
    }

    public void setStationTotalProject02(String stationTotalProject02) {
        this.stationTotalProject02 = stationTotalProject02;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ByProjectIntroduction that = (ByProjectIntroduction) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (stationTotalProject != null ? !stationTotalProject.equals(that.stationTotalProject) : that.stationTotalProject != null)
            return false;
        if (qjtjTotalGcs != null ? !qjtjTotalGcs.equals(that.qjtjTotalGcs) : that.qjtjTotalGcs != null) return false;
        if (fgTotalSchedule != null ? !fgTotalSchedule.equals(that.fgTotalSchedule) : that.fgTotalSchedule != null)
            return false;
        if (sbTotalSchedule != null ? !sbTotalSchedule.equals(that.sbTotalSchedule) : that.sbTotalSchedule != null)
            return false;
        if (tzwcMoney != null ? !tzwcMoney.equals(that.tzwcMoney) : that.tzwcMoney != null) return false;
        if (stationAllCount != null ? !stationAllCount.equals(that.stationAllCount) : that.stationAllCount != null)
            return false;
        if (ykgStationAllCount != null ? !ykgStationAllCount.equals(that.ykgStationAllCount) : that.ykgStationAllCount != null)
            return false;
        if (dgjAllCount != null ? !dgjAllCount.equals(that.dgjAllCount) : that.dgjAllCount != null) return false;
        if (ysfDgjCount != null ? !ysfDgjCount.equals(that.ysfDgjCount) : that.ysfDgjCount != null) return false;
        if (projectIntroduction != null ? !projectIntroduction.equals(that.projectIntroduction) : that.projectIntroduction != null)
            return false;
        if (stationTotalProject02 != null ? !stationTotalProject02.equals(that.stationTotalProject02) : that.stationTotalProject02 != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (stationTotalProject != null ? stationTotalProject.hashCode() : 0);
        result = 31 * result + (qjtjTotalGcs != null ? qjtjTotalGcs.hashCode() : 0);
        result = 31 * result + (fgTotalSchedule != null ? fgTotalSchedule.hashCode() : 0);
        result = 31 * result + (sbTotalSchedule != null ? sbTotalSchedule.hashCode() : 0);
        result = 31 * result + (tzwcMoney != null ? tzwcMoney.hashCode() : 0);
        result = 31 * result + (stationAllCount != null ? stationAllCount.hashCode() : 0);
        result = 31 * result + (ykgStationAllCount != null ? ykgStationAllCount.hashCode() : 0);
        result = 31 * result + (dgjAllCount != null ? dgjAllCount.hashCode() : 0);
        result = 31 * result + (ysfDgjCount != null ? ysfDgjCount.hashCode() : 0);
        result = 31 * result + (projectIntroduction != null ? projectIntroduction.hashCode() : 0);
        result = 31 * result + (stationTotalProject02 != null ? stationTotalProject02.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
