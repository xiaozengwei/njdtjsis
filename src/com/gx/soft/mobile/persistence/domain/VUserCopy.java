package com.gx.soft.mobile.persistence.domain;

import javax.persistence.*;

@Entity
@Table(name = "v_user_copy", schema = "njdtjsis", catalog = "")
public class VUserCopy {
    private String vUserKey;
    private String orgName;
    private String pOrgId;
    private String pOrgName;
    private String orgType;
    private String orgId;
    private String userName;
    private String userPassword;
    private String userId;
    private String userType;
    private String userSex;
    private String userMobileNum;
    private String userStatus;
    private String sysColorId;
    private String cardNo;
    private String userCardId;
    private String comOrgId;
    private String comBdId;
    private String orgLevel;
    private Integer dataOrder;
    private String uioRowId;
    private String userRowId;

    @Id
    @Column(name = "v_user_key")
    public String getvUserKey() {
        return vUserKey;
    }

    public void setvUserKey(String vUserKey) {
        this.vUserKey = vUserKey;
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
    @Column(name = "p_org_id")
    public String getpOrgId() {
        return pOrgId;
    }

    public void setpOrgId(String pOrgId) {
        this.pOrgId = pOrgId;
    }

    @Basic
    @Column(name = "p_org_name")
    public String getpOrgName() {
        return pOrgName;
    }

    public void setpOrgName(String pOrgName) {
        this.pOrgName = pOrgName;
    }

    @Basic
    @Column(name = "org_type")
    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
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
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "user_sex")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_mobile_num")
    public String getUserMobileNum() {
        return userMobileNum;
    }

    public void setUserMobileNum(String userMobileNum) {
        this.userMobileNum = userMobileNum;
    }

    @Basic
    @Column(name = "user_status")
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Basic
    @Column(name = "sys_color_id")
    public String getSysColorId() {
        return sysColorId;
    }

    public void setSysColorId(String sysColorId) {
        this.sysColorId = sysColorId;
    }

    @Basic
    @Column(name = "card_no")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "user_card_id")
    public String getUserCardId() {
        return userCardId;
    }

    public void setUserCardId(String userCardId) {
        this.userCardId = userCardId;
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
    @Column(name = "com_bd_id")
    public String getComBdId() {
        return comBdId;
    }

    public void setComBdId(String comBdId) {
        this.comBdId = comBdId;
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
    @Column(name = "data_order")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "uio_row_id")
    public String getUioRowId() {
        return uioRowId;
    }

    public void setUioRowId(String uioRowId) {
        this.uioRowId = uioRowId;
    }

    @Basic
    @Column(name = "user_row_id")
    public String getUserRowId() {
        return userRowId;
    }

    public void setUserRowId(String userRowId) {
        this.userRowId = userRowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VUserCopy vUserCopy = (VUserCopy) o;

        if (vUserKey != null ? !vUserKey.equals(vUserCopy.vUserKey) : vUserCopy.vUserKey != null) return false;
        if (orgName != null ? !orgName.equals(vUserCopy.orgName) : vUserCopy.orgName != null) return false;
        if (pOrgId != null ? !pOrgId.equals(vUserCopy.pOrgId) : vUserCopy.pOrgId != null) return false;
        if (pOrgName != null ? !pOrgName.equals(vUserCopy.pOrgName) : vUserCopy.pOrgName != null) return false;
        if (orgType != null ? !orgType.equals(vUserCopy.orgType) : vUserCopy.orgType != null) return false;
        if (orgId != null ? !orgId.equals(vUserCopy.orgId) : vUserCopy.orgId != null) return false;
        if (userName != null ? !userName.equals(vUserCopy.userName) : vUserCopy.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(vUserCopy.userPassword) : vUserCopy.userPassword != null)
            return false;
        if (userId != null ? !userId.equals(vUserCopy.userId) : vUserCopy.userId != null) return false;
        if (userType != null ? !userType.equals(vUserCopy.userType) : vUserCopy.userType != null) return false;
        if (userSex != null ? !userSex.equals(vUserCopy.userSex) : vUserCopy.userSex != null) return false;
        if (userMobileNum != null ? !userMobileNum.equals(vUserCopy.userMobileNum) : vUserCopy.userMobileNum != null)
            return false;
        if (userStatus != null ? !userStatus.equals(vUserCopy.userStatus) : vUserCopy.userStatus != null) return false;
        if (sysColorId != null ? !sysColorId.equals(vUserCopy.sysColorId) : vUserCopy.sysColorId != null) return false;
        if (cardNo != null ? !cardNo.equals(vUserCopy.cardNo) : vUserCopy.cardNo != null) return false;
        if (userCardId != null ? !userCardId.equals(vUserCopy.userCardId) : vUserCopy.userCardId != null) return false;
        if (comOrgId != null ? !comOrgId.equals(vUserCopy.comOrgId) : vUserCopy.comOrgId != null) return false;
        if (comBdId != null ? !comBdId.equals(vUserCopy.comBdId) : vUserCopy.comBdId != null) return false;
        if (orgLevel != null ? !orgLevel.equals(vUserCopy.orgLevel) : vUserCopy.orgLevel != null) return false;
        if (dataOrder != null ? !dataOrder.equals(vUserCopy.dataOrder) : vUserCopy.dataOrder != null) return false;
        if (uioRowId != null ? !uioRowId.equals(vUserCopy.uioRowId) : vUserCopy.uioRowId != null) return false;
        if (userRowId != null ? !userRowId.equals(vUserCopy.userRowId) : vUserCopy.userRowId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vUserKey != null ? vUserKey.hashCode() : 0;
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (pOrgId != null ? pOrgId.hashCode() : 0);
        result = 31 * result + (pOrgName != null ? pOrgName.hashCode() : 0);
        result = 31 * result + (orgType != null ? orgType.hashCode() : 0);
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userMobileNum != null ? userMobileNum.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (sysColorId != null ? sysColorId.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (userCardId != null ? userCardId.hashCode() : 0);
        result = 31 * result + (comOrgId != null ? comOrgId.hashCode() : 0);
        result = 31 * result + (comBdId != null ? comBdId.hashCode() : 0);
        result = 31 * result + (orgLevel != null ? orgLevel.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (uioRowId != null ? uioRowId.hashCode() : 0);
        result = 31 * result + (userRowId != null ? userRowId.hashCode() : 0);
        return result;
    }
}
