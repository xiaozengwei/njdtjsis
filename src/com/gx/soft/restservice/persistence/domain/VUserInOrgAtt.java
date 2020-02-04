package com.gx.soft.restservice.persistence.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "v_user_in_org_att", schema = "njdtjsis", catalog = "")
public class VUserInOrgAtt {
    private String attRowId;
    private Date signTime;
    private String userId;
    private String userName;
    private String orgName;
    private String orgId;
    private String bdId;
    private String orgLevel;
    private String ruleName;
    private Timestamp earlyTime;
    private Timestamp lastTime;
    private String count;
    private String workTime;
    private String resultKey;
    private String resultType;
    private String resultCheckType;
    private String signType;
    private String doorControlName;
    private Integer dataOrder;
    private String userType;

    @Id
    @Column(name = "attRowId")
    public String getAttRowId() {
        return attRowId;
    }

    public void setAttRowId(String attRowId) {
        this.attRowId = attRowId;
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
    @Column(name = "orgId")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
    @Column(name = "org_level")
    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
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
    @Column(name = "signType")
    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
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
    @Column(name = "dataOrder")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
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

        VUserInOrgAtt that = (VUserInOrgAtt) o;

        if (attRowId != null ? !attRowId.equals(that.attRowId) : that.attRowId != null) return false;
        if (signTime != null ? !signTime.equals(that.signTime) : that.signTime != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (orgLevel != null ? !orgLevel.equals(that.orgLevel) : that.orgLevel != null) return false;
        if (ruleName != null ? !ruleName.equals(that.ruleName) : that.ruleName != null) return false;
        if (earlyTime != null ? !earlyTime.equals(that.earlyTime) : that.earlyTime != null) return false;
        if (lastTime != null ? !lastTime.equals(that.lastTime) : that.lastTime != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (workTime != null ? !workTime.equals(that.workTime) : that.workTime != null) return false;
        if (resultKey != null ? !resultKey.equals(that.resultKey) : that.resultKey != null) return false;
        if (resultType != null ? !resultType.equals(that.resultType) : that.resultType != null) return false;
        if (resultCheckType != null ? !resultCheckType.equals(that.resultCheckType) : that.resultCheckType != null)
            return false;
        if (signType != null ? !signType.equals(that.signType) : that.signType != null) return false;
        if (doorControlName != null ? !doorControlName.equals(that.doorControlName) : that.doorControlName != null)
            return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attRowId != null ? attRowId.hashCode() : 0;
        result = 31 * result + (signTime != null ? signTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (orgLevel != null ? orgLevel.hashCode() : 0);
        result = 31 * result + (ruleName != null ? ruleName.hashCode() : 0);
        result = 31 * result + (earlyTime != null ? earlyTime.hashCode() : 0);
        result = 31 * result + (lastTime != null ? lastTime.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        result = 31 * result + (resultKey != null ? resultKey.hashCode() : 0);
        result = 31 * result + (resultType != null ? resultType.hashCode() : 0);
        result = 31 * result + (resultCheckType != null ? resultCheckType.hashCode() : 0);
        result = 31 * result + (signType != null ? signType.hashCode() : 0);
        result = 31 * result + (doorControlName != null ? doorControlName.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }
}
