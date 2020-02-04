package com.gx.soft.restservice.persistence.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "gx_sys_attendance_result", schema = "njdtjsis", catalog = "")
public class GxSysAttendanceResult {
    private String rowId;
    private String doorControlName;
    private Date signTime;
    private String userId;
    private String userName;
    private String orgName;
    private String ruleName;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp earlyTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp lastTime;
    private String count;
    private String workTime;
    private String resultKey;
    private String resultType;
    private String resultCheckType;
    private String ext1;
    private Timestamp ext2;
    private Integer ext3;
    private Integer dataOrder;
    private String signType;
    private String userType;

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
    @Column(name = "doorControlName")
    public String getDoorControlName() {
        return doorControlName;
    }

    public void setDoorControlName(String doorControlName) {
        this.doorControlName = doorControlName;
    }

    @Basic
    @Column(name = "signTime")
    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "orgName")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "ruleName")
    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    @Basic
    @Column(name = "earlyTime")
    public Timestamp getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(Timestamp earlyTime) {
        this.earlyTime = earlyTime;
    }

    @Basic
    @Column(name = "lastTime")
    public Timestamp getLastTime() {
        return lastTime;
    }

    public void setLastTime(Timestamp lastTime) {
        this.lastTime = lastTime;
    }

    @Basic
    @Column(name = "count")
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Basic
    @Column(name = "workTime")
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Basic
    @Column(name = "resultKey")
    public String getResultKey() {
        return resultKey;
    }

    public void setResultKey(String resultKey) {
        this.resultKey = resultKey;
    }

    @Basic
    @Column(name = "resultType")
    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Basic
    @Column(name = "resultCheckType")
    public String getResultCheckType() {
        return resultCheckType;
    }

    public void setResultCheckType(String resultCheckType) {
        this.resultCheckType = resultCheckType;
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

    @Basic
    @Column(name = "data_order")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "signType")
    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Basic
    @Column(name = "userType")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GxSysAttendanceResult result = (GxSysAttendanceResult) o;

        if (rowId != null ? !rowId.equals(result.rowId) : result.rowId != null) return false;
        if (doorControlName != null ? !doorControlName.equals(result.doorControlName) : result.doorControlName != null)
            return false;
        if (signTime != null ? !signTime.equals(result.signTime) : result.signTime != null) return false;
        if (userId != null ? !userId.equals(result.userId) : result.userId != null) return false;
        if (userName != null ? !userName.equals(result.userName) : result.userName != null) return false;
        if (orgName != null ? !orgName.equals(result.orgName) : result.orgName != null) return false;
        if (ruleName != null ? !ruleName.equals(result.ruleName) : result.ruleName != null) return false;
        if (earlyTime != null ? !earlyTime.equals(result.earlyTime) : result.earlyTime != null) return false;
        if (lastTime != null ? !lastTime.equals(result.lastTime) : result.lastTime != null) return false;
        if (count != null ? !count.equals(result.count) : result.count != null) return false;
        if (workTime != null ? !workTime.equals(result.workTime) : result.workTime != null) return false;
        if (resultKey != null ? !resultKey.equals(result.resultKey) : result.resultKey != null) return false;
        if (resultType != null ? !resultType.equals(result.resultType) : result.resultType != null) return false;
        if (resultCheckType != null ? !resultCheckType.equals(result.resultCheckType) : result.resultCheckType != null)
            return false;
        if (ext1 != null ? !ext1.equals(result.ext1) : result.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(result.ext2) : result.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(result.ext3) : result.ext3 != null) return false;
        if (dataOrder != null ? !dataOrder.equals(result.dataOrder) : result.dataOrder != null) return false;
        if (signType != null ? !signType.equals(result.signType) : result.signType != null) return false;
        if (userType != null ? !userType.equals(result.userType) : result.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (doorControlName != null ? doorControlName.hashCode() : 0);
        result = 31 * result + (signTime != null ? signTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (ruleName != null ? ruleName.hashCode() : 0);
        result = 31 * result + (earlyTime != null ? earlyTime.hashCode() : 0);
        result = 31 * result + (lastTime != null ? lastTime.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        result = 31 * result + (resultKey != null ? resultKey.hashCode() : 0);
        result = 31 * result + (resultType != null ? resultType.hashCode() : 0);
        result = 31 * result + (resultCheckType != null ? resultCheckType.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (signType != null ? signType.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
