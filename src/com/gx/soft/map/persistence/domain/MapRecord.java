package com.gx.soft.map.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/7/9.
 */
@Entity
@Table(name = "map_record", schema = "njdtjsis", catalog = "")
public class MapRecord {
    private String rowId;
    private String addressWl;
    private String addressJd;
    private String addressWd;
    private String personPhone;
    private Timestamp createTime;
    private Timestamp uploadTime;
    private String bdId;
    private String bdName;
    private String status;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String userId;
    private String userName;

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
    @Column(name = "address_wl")
    public String getAddressWl() {
        return addressWl;
    }

    public void setAddressWl(String addressWl) {
        this.addressWl = addressWl;
    }

    @Basic
    @Column(name = "address_jd")
    public String getAddressJd() {
        return addressJd;
    }

    public void setAddressJd(String addressJd) {
        this.addressJd = addressJd;
    }

    @Basic
    @Column(name = "address_wd")
    public String getAddressWd() {
        return addressWd;
    }

    public void setAddressWd(String addressWd) {
        this.addressWd = addressWd;
    }

    @Basic
    @Column(name = "person_phone")
    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
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
    @Column(name = "upload_time")
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
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
    @Column(name = "bd_name")
    public String getBdName() {
        return bdName;
    }

    public void setBdName(String bdName) {
        this.bdName = bdName;
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
    @Column(name = "ext1")
    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    @Basic
    @Column(name = "ext2")
    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    @Basic
    @Column(name = "ext3")
    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    @Basic
    @Column(name = "ext4")
    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapRecord mapRecord = (MapRecord) o;

        if (rowId != null ? !rowId.equals(mapRecord.rowId) : mapRecord.rowId != null) return false;
        if (addressWl != null ? !addressWl.equals(mapRecord.addressWl) : mapRecord.addressWl != null) return false;
        if (addressJd != null ? !addressJd.equals(mapRecord.addressJd) : mapRecord.addressJd != null) return false;
        if (addressWd != null ? !addressWd.equals(mapRecord.addressWd) : mapRecord.addressWd != null) return false;
        if (personPhone != null ? !personPhone.equals(mapRecord.personPhone) : mapRecord.personPhone != null)
            return false;
        if (createTime != null ? !createTime.equals(mapRecord.createTime) : mapRecord.createTime != null) return false;
        if (uploadTime != null ? !uploadTime.equals(mapRecord.uploadTime) : mapRecord.uploadTime != null) return false;
        if (bdId != null ? !bdId.equals(mapRecord.bdId) : mapRecord.bdId != null) return false;
        if (bdName != null ? !bdName.equals(mapRecord.bdName) : mapRecord.bdName != null) return false;
        if (status != null ? !status.equals(mapRecord.status) : mapRecord.status != null) return false;
        if (ext1 != null ? !ext1.equals(mapRecord.ext1) : mapRecord.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(mapRecord.ext2) : mapRecord.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(mapRecord.ext3) : mapRecord.ext3 != null) return false;
        if (ext4 != null ? !ext4.equals(mapRecord.ext4) : mapRecord.ext4 != null) return false;
        if (userId != null ? !userId.equals(mapRecord.userId) : mapRecord.userId != null) return false;
        if (userName != null ? !userName.equals(mapRecord.userName) : mapRecord.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (addressWl != null ? addressWl.hashCode() : 0);
        result = 31 * result + (addressJd != null ? addressJd.hashCode() : 0);
        result = 31 * result + (addressWd != null ? addressWd.hashCode() : 0);
        result = 31 * result + (personPhone != null ? personPhone.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        result = 31 * result + (ext4 != null ? ext4.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
