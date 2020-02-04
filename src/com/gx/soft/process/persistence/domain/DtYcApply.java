package com.gx.soft.process.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/3.
 */
@Entity
@Table(name = "dt_yc_apply", schema = "njdtjsis", catalog = "")
public class DtYcApply {
    private String rowId;
    private String applicantName;
    private String applicantPhone;
    private String applicantIdCard;
    private Timestamp startTime;
    private String createUserId;
    private String createUserName;
    private Timestamp createTime;
    private String modifyUserId;
    private String modifyUserName;
    private Timestamp modifyTime;
    private String dataType;
    private String dataStatus;
    private String dataOrder;
    private String dataDeleted;
    private String ycAddress;
    private String ycMs;
    private String clYj;
    private String bdId;
    private String relationId;

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
    @Column(name = "applicant_name")
    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    @Basic
    @Column(name = "applicant_phone")
    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    @Basic
    @Column(name = "applicant_id_card")
    public String getApplicantIdCard() {
        return applicantIdCard;
    }

    public void setApplicantIdCard(String applicantIdCard) {
        this.applicantIdCard = applicantIdCard;
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
    @Column(name = "create_user_id")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "create_user_name")
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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
    @Column(name = "modify_user_id")
    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    @Basic
    @Column(name = "modify_user_name")
    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
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
    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "data_deleted")
    public String getDataDeleted() {
        return dataDeleted;
    }

    public void setDataDeleted(String dataDeleted) {
        this.dataDeleted = dataDeleted;
    }

    @Basic
    @Column(name = "yc_address")
    public String getYcAddress() {
        return ycAddress;
    }

    public void setYcAddress(String ycAddress) {
        this.ycAddress = ycAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DtYcApply that = (DtYcApply) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (applicantName != null ? !applicantName.equals(that.applicantName) : that.applicantName != null)
            return false;
        if (applicantPhone != null ? !applicantPhone.equals(that.applicantPhone) : that.applicantPhone != null)
            return false;
        if (applicantIdCard != null ? !applicantIdCard.equals(that.applicantIdCard) : that.applicantIdCard != null)
            return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (createUserName != null ? !createUserName.equals(that.createUserName) : that.createUserName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (modifyUserId != null ? !modifyUserId.equals(that.modifyUserId) : that.modifyUserId != null) return false;
        if (modifyUserName != null ? !modifyUserName.equals(that.modifyUserName) : that.modifyUserName != null)
            return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (dataDeleted != null ? !dataDeleted.equals(that.dataDeleted) : that.dataDeleted != null) return false;
        if (ycAddress != null ? !ycAddress.equals(that.ycAddress) : that.ycAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (applicantName != null ? applicantName.hashCode() : 0);
        result = 31 * result + (applicantPhone != null ? applicantPhone.hashCode() : 0);
        result = 31 * result + (applicantIdCard != null ? applicantIdCard.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (createUserName != null ? createUserName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (modifyUserId != null ? modifyUserId.hashCode() : 0);
        result = 31 * result + (modifyUserName != null ? modifyUserName.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (dataDeleted != null ? dataDeleted.hashCode() : 0);
        result = 31 * result + (ycAddress != null ? ycAddress.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "yc_ms")
    public String getYcMs() {
        return ycMs;
    }

    public void setYcMs(String ycMs) {
        this.ycMs = ycMs;
    }

    @Basic
    @Column(name = "cl_yj")
    public String getClYj() {
        return clYj;
    }

    public void setClYj(String clYj) {
        this.clYj = clYj;
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
    @Column(name = "relation_id")
    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }
}
