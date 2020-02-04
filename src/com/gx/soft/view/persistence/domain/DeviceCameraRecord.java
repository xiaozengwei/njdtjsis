package com.gx.soft.view.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/5/14.
 */
@Entity
@Table(name = "device_camera_record", schema = "njdtjsis", catalog = "")
public class DeviceCameraRecord {
    private String rowId;
    private String wlAddress;
    private String hlsLcAddress;
    private String comId;
    private String bdId;
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
    @Column(name = "row_id", unique = true, nullable = false, length = 40)
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "wl_address")
    public String getWlAddress() {
        return wlAddress;
    }

    public void setWlAddress(String wlAddress) {
        this.wlAddress = wlAddress;
    }

    @Basic
    @Column(name = "hls_lc_address")
    public String getHlsLcAddress() {
        return hlsLcAddress;
    }

    public void setHlsLcAddress(String hlsLcAddress) {
        this.hlsLcAddress = hlsLcAddress;
    }

    @Basic
    @Column(name = "com_id")
    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
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

        DeviceCameraRecord that = (DeviceCameraRecord) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (wlAddress != null ? !wlAddress.equals(that.wlAddress) : that.wlAddress != null) return false;
        if (hlsLcAddress != null ? !hlsLcAddress.equals(that.hlsLcAddress) : that.hlsLcAddress != null) return false;
        if (comId != null ? !comId.equals(that.comId) : that.comId != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
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
        result = 31 * result + (wlAddress != null ? wlAddress.hashCode() : 0);
        result = 31 * result + (hlsLcAddress != null ? hlsLcAddress.hashCode() : 0);
        result = 31 * result + (comId != null ? comId.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
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
