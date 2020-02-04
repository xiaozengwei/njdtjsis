package com.gx.soft.attendance.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gx_sys_ent", schema = "njdtjsis", catalog = "")
public class GxSysEnt {
    private String rowId;
    private String enrranceAddress;
    private String entranceAddressAs;
    private String entranceEquipmentName;
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
    @Column(name = "enrrance_address")
    public String getEnrranceAddress() {
        return enrranceAddress;
    }

    public void setEnrranceAddress(String enrranceAddress) {
        this.enrranceAddress = enrranceAddress;
    }

    @Basic
    @Column(name = "entrance_address_as")
    public String getEntranceAddressAs() {
        return entranceAddressAs;
    }

    public void setEntranceAddressAs(String entranceAddressAs) {
        this.entranceAddressAs = entranceAddressAs;
    }

    @Basic
    @Column(name = "entrance_equipment_name")
    public String getEntranceEquipmentName() {
        return entranceEquipmentName;
    }

    public void setEntranceEquipmentName(String entranceEquipmentName) {
        this.entranceEquipmentName = entranceEquipmentName;
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

        GxSysEnt gxSysEnt = (GxSysEnt) o;

        if (rowId != null ? !rowId.equals(gxSysEnt.rowId) : gxSysEnt.rowId != null) return false;
        if (enrranceAddress != null ? !enrranceAddress.equals(gxSysEnt.enrranceAddress) : gxSysEnt.enrranceAddress != null)
            return false;
        if (entranceAddressAs != null ? !entranceAddressAs.equals(gxSysEnt.entranceAddressAs) : gxSysEnt.entranceAddressAs != null)
            return false;
        if (entranceEquipmentName != null ? !entranceEquipmentName.equals(gxSysEnt.entranceEquipmentName) : gxSysEnt.entranceEquipmentName != null)
            return false;
        if (createTime != null ? !createTime.equals(gxSysEnt.createTime) : gxSysEnt.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(gxSysEnt.updateTime) : gxSysEnt.updateTime != null) return false;
        if (status != null ? !status.equals(gxSysEnt.status) : gxSysEnt.status != null) return false;
        if (orderNum != null ? !orderNum.equals(gxSysEnt.orderNum) : gxSysEnt.orderNum != null) return false;
        if (ext1 != null ? !ext1.equals(gxSysEnt.ext1) : gxSysEnt.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(gxSysEnt.ext2) : gxSysEnt.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(gxSysEnt.ext3) : gxSysEnt.ext3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (enrranceAddress != null ? enrranceAddress.hashCode() : 0);
        result = 31 * result + (entranceAddressAs != null ? entranceAddressAs.hashCode() : 0);
        result = 31 * result + (entranceEquipmentName != null ? entranceEquipmentName.hashCode() : 0);
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
