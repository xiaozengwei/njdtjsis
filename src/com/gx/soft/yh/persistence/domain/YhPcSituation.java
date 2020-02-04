package com.gx.soft.yh.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/11.
 */
@Entity
@Table(name = "yh_pc_situation", schema = "njdtjsis", catalog = "")
public class YhPcSituation {
    private String rowId;
    private String yhName;
    private String yhProblem;
    private String zgSituation;
    private String hxsgGzcs;
    private String yhzgFzr;
    private String sgdwFzr;
    private String jldwFzr;
    private String jsdwFzr;
    private String tbOrgName;
    private String tbUserId;
    private String tbUserName;
    private Timestamp createTime;
    private Date tbDate;
    private String comOrgId;
    private String bdId;
    private String bdName;
    private String dataType;
    private String dataStatus;
    private Integer dataOrder;
    private String dataDelete;
    private Timestamp startTime;
    private Timestamp endTime;
    private Integer timePeriod;
    private String briefIntro;

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
    @Column(name = "yh_name")
    public String getYhName() {
        return yhName;
    }

    public void setYhName(String yhName) {
        this.yhName = yhName;
    }

    @Basic
    @Column(name = "yh_problem")
    public String getYhProblem() {
        return yhProblem;
    }

    public void setYhProblem(String yhProblem) {
        this.yhProblem = yhProblem;
    }

    @Basic
    @Column(name = "zg_situation")
    public String getZgSituation() {
        return zgSituation;
    }

    public void setZgSituation(String zgSituation) {
        this.zgSituation = zgSituation;
    }

    @Basic
    @Column(name = "hxsg_gzcs")
    public String getHxsgGzcs() {
        return hxsgGzcs;
    }

    public void setHxsgGzcs(String hxsgGzcs) {
        this.hxsgGzcs = hxsgGzcs;
    }

    @Basic
    @Column(name = "yhzg_fzr")
    public String getYhzgFzr() {
        return yhzgFzr;
    }

    public void setYhzgFzr(String yhzgFzr) {
        this.yhzgFzr = yhzgFzr;
    }

    @Basic
    @Column(name = "sgdw_fzr")
    public String getSgdwFzr() {
        return sgdwFzr;
    }

    public void setSgdwFzr(String sgdwFzr) {
        this.sgdwFzr = sgdwFzr;
    }

    @Basic
    @Column(name = "jldw_fzr")
    public String getJldwFzr() {
        return jldwFzr;
    }

    public void setJldwFzr(String jldwFzr) {
        this.jldwFzr = jldwFzr;
    }

    @Basic
    @Column(name = "jsdw_fzr")
    public String getJsdwFzr() {
        return jsdwFzr;
    }

    public void setJsdwFzr(String jsdwFzr) {
        this.jsdwFzr = jsdwFzr;
    }

    @Basic
    @Column(name = "tb_org_name")
    public String getTbOrgName() {
        return tbOrgName;
    }

    public void setTbOrgName(String tbOrgName) {
        this.tbOrgName = tbOrgName;
    }

    @Basic
    @Column(name = "tb_user_id")
    public String getTbUserId() {
        return tbUserId;
    }

    public void setTbUserId(String tbUserId) {
        this.tbUserId = tbUserId;
    }

    @Basic
    @Column(name = "tb_user_name")
    public String getTbUserName() {
        return tbUserName;
    }

    public void setTbUserName(String tbUserName) {
        this.tbUserName = tbUserName;
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
    @Column(name = "tb_date")
    public Date getTbDate() {
        return tbDate;
    }

    public void setTbDate(Date tbDate) {
        this.tbDate = tbDate;
    }

    @Basic
    @Column(name = "com_org_id")
    public String getComOrgId() {
        return comOrgId;
    }

    public void setComOrgId(String comOrgId) {
        this.comOrgId = comOrgId;
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
    @Column(name = "data_type")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Basic
    @Column(name = "data_order")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "data_delete")
    public String getDataDelete() {
        return dataDelete;
    }

    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "time_period")
    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Basic
    @Column(name = "brief_intro")
    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YhPcSituation that = (YhPcSituation) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (yhName != null ? !yhName.equals(that.yhName) : that.yhName != null) return false;
        if (yhProblem != null ? !yhProblem.equals(that.yhProblem) : that.yhProblem != null) return false;
        if (zgSituation != null ? !zgSituation.equals(that.zgSituation) : that.zgSituation != null) return false;
        if (hxsgGzcs != null ? !hxsgGzcs.equals(that.hxsgGzcs) : that.hxsgGzcs != null) return false;
        if (yhzgFzr != null ? !yhzgFzr.equals(that.yhzgFzr) : that.yhzgFzr != null) return false;
        if (sgdwFzr != null ? !sgdwFzr.equals(that.sgdwFzr) : that.sgdwFzr != null) return false;
        if (jldwFzr != null ? !jldwFzr.equals(that.jldwFzr) : that.jldwFzr != null) return false;
        if (jsdwFzr != null ? !jsdwFzr.equals(that.jsdwFzr) : that.jsdwFzr != null) return false;
        if (tbOrgName != null ? !tbOrgName.equals(that.tbOrgName) : that.tbOrgName != null) return false;
        if (tbUserId != null ? !tbUserId.equals(that.tbUserId) : that.tbUserId != null) return false;
        if (tbUserName != null ? !tbUserName.equals(that.tbUserName) : that.tbUserName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (tbDate != null ? !tbDate.equals(that.tbDate) : that.tbDate != null) return false;
        if (comOrgId != null ? !comOrgId.equals(that.comOrgId) : that.comOrgId != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (bdName != null ? !bdName.equals(that.bdName) : that.bdName != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (dataDelete != null ? !dataDelete.equals(that.dataDelete) : that.dataDelete != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (timePeriod != null ? !timePeriod.equals(that.timePeriod) : that.timePeriod != null) return false;
        if (briefIntro != null ? !briefIntro.equals(that.briefIntro) : that.briefIntro != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (yhName != null ? yhName.hashCode() : 0);
        result = 31 * result + (yhProblem != null ? yhProblem.hashCode() : 0);
        result = 31 * result + (zgSituation != null ? zgSituation.hashCode() : 0);
        result = 31 * result + (hxsgGzcs != null ? hxsgGzcs.hashCode() : 0);
        result = 31 * result + (yhzgFzr != null ? yhzgFzr.hashCode() : 0);
        result = 31 * result + (sgdwFzr != null ? sgdwFzr.hashCode() : 0);
        result = 31 * result + (jldwFzr != null ? jldwFzr.hashCode() : 0);
        result = 31 * result + (jsdwFzr != null ? jsdwFzr.hashCode() : 0);
        result = 31 * result + (tbOrgName != null ? tbOrgName.hashCode() : 0);
        result = 31 * result + (tbUserId != null ? tbUserId.hashCode() : 0);
        result = 31 * result + (tbUserName != null ? tbUserName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (tbDate != null ? tbDate.hashCode() : 0);
        result = 31 * result + (comOrgId != null ? comOrgId.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (dataDelete != null ? dataDelete.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (timePeriod != null ? timePeriod.hashCode() : 0);
        result = 31 * result + (briefIntro != null ? briefIntro.hashCode() : 0);
        return result;
    }
}
