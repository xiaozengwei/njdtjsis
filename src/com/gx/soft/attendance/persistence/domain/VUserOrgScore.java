package com.gx.soft.attendance.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "v_user_org_score", schema = "njdtjsis", catalog = "")
public class VUserOrgScore {
    private String vScoreUserKey;
    private String scoreKey;
    private Double recordScore;
    private String recordType;
    private Date recordTime;
    private String userKey;
    private String userId;
    private String userName;
    private String orgId;
    private String orgName;
    private String parentOrgId;
    private String parentOrgName;
    private Integer dataOrder;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "v_score_user_key")
    public String getvScoreUserKey() {
        return vScoreUserKey;
    }

    public void setvScoreUserKey(String vScoreUserKey) {
        this.vScoreUserKey = vScoreUserKey;
    }

    @Basic
    @Column(name = "score_key")
    public String getScoreKey() {
        return scoreKey;
    }

    public void setScoreKey(String scoreKey) {
        this.scoreKey = scoreKey;
    }

    @Basic
    @Column(name = "record_score")
    public Double getRecordScore() {
        return recordScore;
    }

    public void setRecordScore(Double recordScore) {
        this.recordScore = recordScore;
    }

    @Basic
    @Column(name = "record_type")
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @Basic
    @Column(name = "record_time")
    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "user_key")
    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "org_id")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
    @Column(name = "parent_org_id")
    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    @Basic
    @Column(name = "parent_org_name")
    public String getParentOrgName() {
        return parentOrgName;
    }

    public void setParentOrgName(String parentOrgName) {
        this.parentOrgName = parentOrgName;
    }

    @Basic
    @Column(name = "data_order")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VUserOrgScore that = (VUserOrgScore) o;

        if (vScoreUserKey != null ? !vScoreUserKey.equals(that.vScoreUserKey) : that.vScoreUserKey != null)
            return false;
        if (scoreKey != null ? !scoreKey.equals(that.scoreKey) : that.scoreKey != null) return false;
        if (recordScore != null ? !recordScore.equals(that.recordScore) : that.recordScore != null) return false;
        if (recordType != null ? !recordType.equals(that.recordType) : that.recordType != null) return false;
        if (recordTime != null ? !recordTime.equals(that.recordTime) : that.recordTime != null) return false;
        if (userKey != null ? !userKey.equals(that.userKey) : that.userKey != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (parentOrgId != null ? !parentOrgId.equals(that.parentOrgId) : that.parentOrgId != null) return false;
        if (parentOrgName != null ? !parentOrgName.equals(that.parentOrgName) : that.parentOrgName != null)
            return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vScoreUserKey != null ? vScoreUserKey.hashCode() : 0;
        result = 31 * result + (scoreKey != null ? scoreKey.hashCode() : 0);
        result = 31 * result + (recordScore != null ? recordScore.hashCode() : 0);
        result = 31 * result + (recordType != null ? recordType.hashCode() : 0);
        result = 31 * result + (recordTime != null ? recordTime.hashCode() : 0);
        result = 31 * result + (userKey != null ? userKey.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (parentOrgId != null ? parentOrgId.hashCode() : 0);
        result = 31 * result + (parentOrgName != null ? parentOrgName.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        return result;
    }
}
