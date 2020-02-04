package com.gx.soft.attendance.persistence.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "v_att_all", schema = "njdtjsis", catalog = "")
public class VAttAll {
    private String vAttUserKey;
    private String uniqueId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp signTime;
    private String doorControlName;
    private String certificateNo;
    private String projectId;
    private String imageUrl;
    private String signType;
    private String userKey;
    private String userId;
    private String userName;
    private String userType;
    private String orgId;
    private String orgName;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "v_att_user_key")
    public String getvAttUserKey() {
        return vAttUserKey;
    }

    public void setvAttUserKey(String vAttUserKey) {
        this.vAttUserKey = vAttUserKey;
    }

    @Basic
    @Column(name = "uniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Basic
    @Column(name = "signTime")
    public Timestamp getSignTime() {
        return signTime;
    }

    public void setSignTime(Timestamp signTime) {
        this.signTime = signTime;
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
    @Column(name = "certificateNo")
    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    @Basic
    @Column(name = "projectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VAttAll vAttAll = (VAttAll) o;

        if (vAttUserKey != null ? !vAttUserKey.equals(vAttAll.vAttUserKey) : vAttAll.vAttUserKey != null) return false;
        if (uniqueId != null ? !uniqueId.equals(vAttAll.uniqueId) : vAttAll.uniqueId != null) return false;
        if (signTime != null ? !signTime.equals(vAttAll.signTime) : vAttAll.signTime != null) return false;
        if (doorControlName != null ? !doorControlName.equals(vAttAll.doorControlName) : vAttAll.doorControlName != null)
            return false;
        if (certificateNo != null ? !certificateNo.equals(vAttAll.certificateNo) : vAttAll.certificateNo != null)
            return false;
        if (projectId != null ? !projectId.equals(vAttAll.projectId) : vAttAll.projectId != null) return false;
        if (imageUrl != null ? !imageUrl.equals(vAttAll.imageUrl) : vAttAll.imageUrl != null) return false;
        if (signType != null ? !signType.equals(vAttAll.signType) : vAttAll.signType != null) return false;
        if (userKey != null ? !userKey.equals(vAttAll.userKey) : vAttAll.userKey != null) return false;
        if (userId != null ? !userId.equals(vAttAll.userId) : vAttAll.userId != null) return false;
        if (userName != null ? !userName.equals(vAttAll.userName) : vAttAll.userName != null) return false;
        if (userType != null ? !userType.equals(vAttAll.userType) : vAttAll.userType != null) return false;
        if (orgId != null ? !orgId.equals(vAttAll.orgId) : vAttAll.orgId != null) return false;
        if (orgName != null ? !orgName.equals(vAttAll.orgName) : vAttAll.orgName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vAttUserKey != null ? vAttUserKey.hashCode() : 0;
        result = 31 * result + (uniqueId != null ? uniqueId.hashCode() : 0);
        result = 31 * result + (signTime != null ? signTime.hashCode() : 0);
        result = 31 * result + (doorControlName != null ? doorControlName.hashCode() : 0);
        result = 31 * result + (certificateNo != null ? certificateNo.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (signType != null ? signType.hashCode() : 0);
        result = 31 * result + (userKey != null ? userKey.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        return result;
    }
}
