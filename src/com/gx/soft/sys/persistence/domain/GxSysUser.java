package com.gx.soft.sys.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gx_sys_user", schema = "njdtjsis", catalog = "")
public class GxSysUser {
    private String rowId;
    private String userName;
    private String userShowName;
    private String userEnName;
    private String userId;
    private Timestamp createTime;
    private String createUserId;
    private Timestamp modifyTime;
    private String modifyUserId;
    private String dataStatus;
    private Integer dataOrder;
    private String userMobileNum;
    private String userSex;
    private String userType;
    private String userPhoto;
    private String userMail;
    private String userLevel;
    private Integer powerLevel;
    private String userCardId;
    private String sysColorId;
    private String bdName;
    private String bdId;
    private String cardNo;
    private String clientId;

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
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_show_name")
    public String getUserShowName() {
        return userShowName;
    }

    public void setUserShowName(String userShowName) {
        this.userShowName = userShowName;
    }

    @Basic
    @Column(name = "user_en_name")
    public String getUserEnName() {
        return userEnName;
    }

    public void setUserEnName(String userEnName) {
        this.userEnName = userEnName;
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
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "create_user_id")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "modify_time")
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "modify_user_id")
    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
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
    @Column(name = "user_mobile_num")
    public String getUserMobileNum() {
        return userMobileNum;
    }

    public void setUserMobileNum(String userMobileNum) {
        this.userMobileNum = userMobileNum;
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
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "user_photo")
    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    @Basic
    @Column(name = "user_mail")
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Basic
    @Column(name = "user_level")
    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    @Basic
    @Column(name = "power_level")
    public Integer getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(Integer powerLevel) {
        this.powerLevel = powerLevel;
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
    @Column(name = "sys_color_id")
    public String getSysColorId() {
        return sysColorId;
    }

    public void setSysColorId(String sysColorId) {
        this.sysColorId = sysColorId;
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
    @Column(name = "bd_id")
    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
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

        GxSysUser gxSysUser = (GxSysUser) o;

        if (rowId != null ? !rowId.equals(gxSysUser.rowId) : gxSysUser.rowId != null) return false;
        if (userName != null ? !userName.equals(gxSysUser.userName) : gxSysUser.userName != null) return false;
        if (userShowName != null ? !userShowName.equals(gxSysUser.userShowName) : gxSysUser.userShowName != null)
            return false;
        if (userEnName != null ? !userEnName.equals(gxSysUser.userEnName) : gxSysUser.userEnName != null) return false;
        if (userId != null ? !userId.equals(gxSysUser.userId) : gxSysUser.userId != null) return false;
        if (createTime != null ? !createTime.equals(gxSysUser.createTime) : gxSysUser.createTime != null) return false;
        if (createUserId != null ? !createUserId.equals(gxSysUser.createUserId) : gxSysUser.createUserId != null)
            return false;
        if (modifyTime != null ? !modifyTime.equals(gxSysUser.modifyTime) : gxSysUser.modifyTime != null) return false;
        if (modifyUserId != null ? !modifyUserId.equals(gxSysUser.modifyUserId) : gxSysUser.modifyUserId != null)
            return false;
        if (dataStatus != null ? !dataStatus.equals(gxSysUser.dataStatus) : gxSysUser.dataStatus != null) return false;
        if (dataOrder != null ? !dataOrder.equals(gxSysUser.dataOrder) : gxSysUser.dataOrder != null) return false;
        if (userMobileNum != null ? !userMobileNum.equals(gxSysUser.userMobileNum) : gxSysUser.userMobileNum != null)
            return false;
        if (userSex != null ? !userSex.equals(gxSysUser.userSex) : gxSysUser.userSex != null) return false;
        if (userType != null ? !userType.equals(gxSysUser.userType) : gxSysUser.userType != null) return false;
        if (userPhoto != null ? !userPhoto.equals(gxSysUser.userPhoto) : gxSysUser.userPhoto != null) return false;
        if (userMail != null ? !userMail.equals(gxSysUser.userMail) : gxSysUser.userMail != null) return false;
        if (userLevel != null ? !userLevel.equals(gxSysUser.userLevel) : gxSysUser.userLevel != null) return false;
        if (powerLevel != null ? !powerLevel.equals(gxSysUser.powerLevel) : gxSysUser.powerLevel != null) return false;
        if (userCardId != null ? !userCardId.equals(gxSysUser.userCardId) : gxSysUser.userCardId != null) return false;
        if (sysColorId != null ? !sysColorId.equals(gxSysUser.sysColorId) : gxSysUser.sysColorId != null) return false;
        if (bdName != null ? !bdName.equals(gxSysUser.bdName) : gxSysUser.bdName != null) return false;
        if (bdId != null ? !bdId.equals(gxSysUser.bdId) : gxSysUser.bdId != null) return false;
        if (cardNo != null ? !cardNo.equals(gxSysUser.cardNo) : gxSysUser.cardNo != null) return false;
        if (clientId != null ? !clientId.equals(gxSysUser.clientId) : gxSysUser.clientId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userShowName != null ? userShowName.hashCode() : 0);
        result = 31 * result + (userEnName != null ? userEnName.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (modifyUserId != null ? modifyUserId.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (userMobileNum != null ? userMobileNum.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (userPhoto != null ? userPhoto.hashCode() : 0);
        result = 31 * result + (userMail != null ? userMail.hashCode() : 0);
        result = 31 * result + (userLevel != null ? userLevel.hashCode() : 0);
        result = 31 * result + (powerLevel != null ? powerLevel.hashCode() : 0);
        result = 31 * result + (userCardId != null ? userCardId.hashCode() : 0);
        result = 31 * result + (sysColorId != null ? sysColorId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }
}
