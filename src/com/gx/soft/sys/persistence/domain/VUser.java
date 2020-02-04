package com.gx.soft.sys.persistence.domain;

import javax.persistence.*;

/**
 * Created by adminstrator on 2019/7/16.
 */
@Entity
@Table(name = "v_user", schema = "njdtjsis", catalog = "")
public class VUser {
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
    private String userMobileNum;
    private String userStatus;
    private String sysColorId;
    private String userCardId;
    private String comOrgId;
    private String comBdId;
    private Integer dataOrder;
    private String uioRowId;
    private String userRowId;
    private String clientId;

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

    @Basic
    @Column(name = "client_id")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VUser vUser = (VUser) o;

        if (vUserKey != null ? !vUserKey.equals(vUser.vUserKey) : vUser.vUserKey != null) return false;
        if (orgName != null ? !orgName.equals(vUser.orgName) : vUser.orgName != null) return false;
        if (pOrgId != null ? !pOrgId.equals(vUser.pOrgId) : vUser.pOrgId != null) return false;
        if (pOrgName != null ? !pOrgName.equals(vUser.pOrgName) : vUser.pOrgName != null) return false;
        if (orgType != null ? !orgType.equals(vUser.orgType) : vUser.orgType != null) return false;
        if (orgId != null ? !orgId.equals(vUser.orgId) : vUser.orgId != null) return false;
        if (userName != null ? !userName.equals(vUser.userName) : vUser.userName != null) return false;
        if (userPassword != null ? !userPassword.equals(vUser.userPassword) : vUser.userPassword != null) return false;
        if (userId != null ? !userId.equals(vUser.userId) : vUser.userId != null) return false;
        if (userType != null ? !userType.equals(vUser.userType) : vUser.userType != null) return false;
        if (userMobileNum != null ? !userMobileNum.equals(vUser.userMobileNum) : vUser.userMobileNum != null)
            return false;
        if (userStatus != null ? !userStatus.equals(vUser.userStatus) : vUser.userStatus != null) return false;
        if (sysColorId != null ? !sysColorId.equals(vUser.sysColorId) : vUser.sysColorId != null) return false;
        if (userCardId != null ? !userCardId.equals(vUser.userCardId) : vUser.userCardId != null) return false;
        if (comOrgId != null ? !comOrgId.equals(vUser.comOrgId) : vUser.comOrgId != null) return false;
        if (comBdId != null ? !comBdId.equals(vUser.comBdId) : vUser.comBdId != null) return false;
        if (dataOrder != null ? !dataOrder.equals(vUser.dataOrder) : vUser.dataOrder != null) return false;
        if (uioRowId != null ? !uioRowId.equals(vUser.uioRowId) : vUser.uioRowId != null) return false;
        if (userRowId != null ? !userRowId.equals(vUser.userRowId) : vUser.userRowId != null) return false;
        if (clientId != null ? !clientId.equals(vUser.clientId) : vUser.clientId != null) return false;

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
        result = 31 * result + (userMobileNum != null ? userMobileNum.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        result = 31 * result + (sysColorId != null ? sysColorId.hashCode() : 0);
        result = 31 * result + (userCardId != null ? userCardId.hashCode() : 0);
        result = 31 * result + (comOrgId != null ? comOrgId.hashCode() : 0);
        result = 31 * result + (comBdId != null ? comBdId.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (uioRowId != null ? uioRowId.hashCode() : 0);
        result = 31 * result + (userRowId != null ? userRowId.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }
}
