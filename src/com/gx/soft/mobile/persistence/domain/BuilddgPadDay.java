package com.gx.soft.mobile.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/5/28.
 */
@Entity
@Table(name = "builddg_pad_day", schema = "njdtjsis", catalog = "")
public class BuilddgPadDay {
    private String rowId;
    private String bdId;
    private String bdName;
    private String dgNum;
    private String dgReson;
    private String dgSg;
    private String dgLevel;
    private String contrlAnswer;
    private String contrlTime;
    private String buildManager;
    private String levelManager;
    private String safeManager;
    private String crTime;
    private Timestamp createTime;

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
    @Column(name = "bd_id")
    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    @Basic
    @Column(name = "bd_name")
    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
    }

    @Basic
    @Column(name = "dg_num")
    public String getDgNum() {
        return dgNum;
    }

    public void setDgNum(String dgNum) {
        this.dgNum = dgNum;
    }

    @Basic
    @Column(name = "dg_reson")
    public String getDgReson() {
        return dgReson;
    }

    public void setDgReson(String dgReson) {
        this.dgReson = dgReson;
    }

    @Basic
    @Column(name = "dg_sg")
    public String getDgSg() {
        return dgSg;
    }

    public void setDgSg(String dgSg) {
        this.dgSg = dgSg;
    }

    @Basic
    @Column(name = "dg_level")
    public String getDgLevel() {
        return dgLevel;
    }

    public void setDgLevel(String dgLevel) {
        this.dgLevel = dgLevel;
    }

    @Basic
    @Column(name = "contrl_answer")
    public String getContrlAnswer() {
        return contrlAnswer;
    }

    public void setContrlAnswer(String contrlAnswer) {
        this.contrlAnswer = contrlAnswer;
    }

    @Basic
    @Column(name = "contrl_time")
    public String getContrlTime() {
        return contrlTime;
    }

    public void setContrlTime(String contrlTime) {
        this.contrlTime = contrlTime;
    }

    @Basic
    @Column(name = "build_manager")
    public String getBuildManager() {
        return buildManager;
    }

    public void setBuildManager(String buildManager) {
        this.buildManager = buildManager;
    }

    @Basic
    @Column(name = "level_manager")
    public String getLevelManager() {
        return levelManager;
    }

    public void setLevelManager(String levelManager) {
        this.levelManager = levelManager;
    }

    @Basic
    @Column(name = "safe_manager")
    public String getSafeManager() {
        return safeManager;
    }

    public void setSafeManager(String safeManager) {
        this.safeManager = safeManager;
    }

    @Basic
    @Column(name = "cr_time")
    public String getCrTime() {
        return crTime;
    }

    public void setCrTime(String crTime) {
        this.crTime = crTime;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuilddgPadDay that = (BuilddgPadDay) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (bdName != null ? !bdName.equals(that.bdName) : that.bdName != null) return false;
        if (dgNum != null ? !dgNum.equals(that.dgNum) : that.dgNum != null) return false;
        if (dgReson != null ? !dgReson.equals(that.dgReson) : that.dgReson != null) return false;
        if (dgSg != null ? !dgSg.equals(that.dgSg) : that.dgSg != null) return false;
        if (dgLevel != null ? !dgLevel.equals(that.dgLevel) : that.dgLevel != null) return false;
        if (contrlAnswer != null ? !contrlAnswer.equals(that.contrlAnswer) : that.contrlAnswer != null) return false;
        if (contrlTime != null ? !contrlTime.equals(that.contrlTime) : that.contrlTime != null) return false;
        if (buildManager != null ? !buildManager.equals(that.buildManager) : that.buildManager != null) return false;
        if (levelManager != null ? !levelManager.equals(that.levelManager) : that.levelManager != null) return false;
        if (safeManager != null ? !safeManager.equals(that.safeManager) : that.safeManager != null) return false;
        if (crTime != null ? !crTime.equals(that.crTime) : that.crTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (dgNum != null ? dgNum.hashCode() : 0);
        result = 31 * result + (dgReson != null ? dgReson.hashCode() : 0);
        result = 31 * result + (dgSg != null ? dgSg.hashCode() : 0);
        result = 31 * result + (dgLevel != null ? dgLevel.hashCode() : 0);
        result = 31 * result + (contrlAnswer != null ? contrlAnswer.hashCode() : 0);
        result = 31 * result + (contrlTime != null ? contrlTime.hashCode() : 0);
        result = 31 * result + (buildManager != null ? buildManager.hashCode() : 0);
        result = 31 * result + (levelManager != null ? levelManager.hashCode() : 0);
        result = 31 * result + (safeManager != null ? safeManager.hashCode() : 0);
        result = 31 * result + (crTime != null ? crTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
