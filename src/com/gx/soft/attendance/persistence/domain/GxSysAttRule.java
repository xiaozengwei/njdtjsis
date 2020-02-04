package com.gx.soft.attendance.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gx_sys_att_rule", schema = "njdtjsis", catalog = "")
public class GxSysAttRule {
    private String rowId;
    private String ruleName;
    private String ruleTime;
    private String rulePeriod;
    private String entranceId;
    private String ruleAddress;
    private String ruleEquipmentName;
    private String orgRowId;
    private String comBdId;
    private String orgName;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String status;
    private Integer orderNum;
    private String ext1;
    private Timestamp ext2;
    private Integer ext3;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "rule_name")
    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    @Basic
    @Column(name = "rule_time")
    public String getRuleTime() {
        return ruleTime;
    }

    public void setRuleTime(String ruleTime) {
        this.ruleTime = ruleTime;
    }

    @Basic
    @Column(name = "rule_period")
    public String getRulePeriod() {
        return rulePeriod;
    }

    public void setRulePeriod(String rulePeriod) {
        this.rulePeriod = rulePeriod;
    }

    @Basic
    @Column(name = "entrance_id")
    public String getEntranceId() {
        return entranceId;
    }

    public void setEntranceId(String entranceId) {
        this.entranceId = entranceId;
    }

    @Basic
    @Column(name = "rule_address")
    public String getRuleAddress() {
        return ruleAddress;
    }

    public void setRuleAddress(String ruleAddress) {
        this.ruleAddress = ruleAddress;
    }

    @Basic
    @Column(name = "rule_equipment_name")
    public String getRuleEquipmentName() {
        return ruleEquipmentName;
    }

    public void setRuleEquipmentName(String ruleEquipmentName) {
        this.ruleEquipmentName = ruleEquipmentName;
    }

    @Basic
    @Column(name = "org_row_id")
    public String getOrgRowId() {
        return orgRowId;
    }

    public void setOrgRowId(String orgRowId) {
        this.orgRowId = orgRowId;
    }

    @Basic
    @Column(name = "com_bd_id")
    public String getComBdId() {
        return comBdId;
    }

    public void setComBdId(String comBdId) {
        this.comBdId = comBdId;
    }

    @Basic
    @Column(name = "org_name")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "order_num")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "ext1")
    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    @Basic
    @Column(name = "ext2")
    public Timestamp getExt2() {
        return ext2;
    }

    public void setExt2(Timestamp ext2) {
        this.ext2 = ext2;
    }

    @Basic
    @Column(name = "ext3")
    public Integer getExt3() {
        return ext3;
    }

    public void setExt3(Integer ext3) {
        this.ext3 = ext3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GxSysAttRule that = (GxSysAttRule) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (ruleName != null ? !ruleName.equals(that.ruleName) : that.ruleName != null) return false;
        if (ruleTime != null ? !ruleTime.equals(that.ruleTime) : that.ruleTime != null) return false;
        if (rulePeriod != null ? !rulePeriod.equals(that.rulePeriod) : that.rulePeriod != null) return false;
        if (entranceId != null ? !entranceId.equals(that.entranceId) : that.entranceId != null) return false;
        if (ruleAddress != null ? !ruleAddress.equals(that.ruleAddress) : that.ruleAddress != null) return false;
        if (ruleEquipmentName != null ? !ruleEquipmentName.equals(that.ruleEquipmentName) : that.ruleEquipmentName != null)
            return false;
        if (orgRowId != null ? !orgRowId.equals(that.orgRowId) : that.orgRowId != null) return false;
        if (comBdId != null ? !comBdId.equals(that.comBdId) : that.comBdId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (orderNum != null ? !orderNum.equals(that.orderNum) : that.orderNum != null) return false;
        if (ext1 != null ? !ext1.equals(that.ext1) : that.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(that.ext3) : that.ext3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (ruleName != null ? ruleName.hashCode() : 0);
        result = 31 * result + (ruleTime != null ? ruleTime.hashCode() : 0);
        result = 31 * result + (rulePeriod != null ? rulePeriod.hashCode() : 0);
        result = 31 * result + (entranceId != null ? entranceId.hashCode() : 0);
        result = 31 * result + (ruleAddress != null ? ruleAddress.hashCode() : 0);
        result = 31 * result + (ruleEquipmentName != null ? ruleEquipmentName.hashCode() : 0);
        result = 31 * result + (orgRowId != null ? orgRowId.hashCode() : 0);
        result = 31 * result + (comBdId != null ? comBdId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        return result;
    }
}
