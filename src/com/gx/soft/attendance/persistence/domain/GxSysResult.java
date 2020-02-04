package com.gx.soft.attendance.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "gx_sys_result", schema = "njdtjsis", catalog = "")
public class GxSysResult {
    private String rowId;
    private String resultType;
    private String resultTypeChange;
    private String userId;
    private Date resultTime;
    private String attendanceStatus;
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
    @Column(name = "result_type")
    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Basic
    @Column(name = "result_type_change")
    public String getResultTypeChange() {
        return resultTypeChange;
    }

    public void setResultTypeChange(String resultTypeChange) {
        this.resultTypeChange = resultTypeChange;
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
    @Column(name = "result_time")
    public Date getResultTime() {
        return resultTime;
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    @Basic
    @Column(name = "attendance_status")
    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
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

        GxSysResult that = (GxSysResult) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (resultType != null ? !resultType.equals(that.resultType) : that.resultType != null) return false;
        if (resultTypeChange != null ? !resultTypeChange.equals(that.resultTypeChange) : that.resultTypeChange != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (resultTime != null ? !resultTime.equals(that.resultTime) : that.resultTime != null) return false;
        if (attendanceStatus != null ? !attendanceStatus.equals(that.attendanceStatus) : that.attendanceStatus != null)
            return false;
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
        result = 31 * result + (resultType != null ? resultType.hashCode() : 0);
        result = 31 * result + (resultTypeChange != null ? resultTypeChange.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (resultTime != null ? resultTime.hashCode() : 0);
        result = 31 * result + (attendanceStatus != null ? attendanceStatus.hashCode() : 0);
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
