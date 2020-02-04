package com.gx.soft.danagerproject.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/20.
 */
@Entity
@Table(name = "danager_project", schema = "njdtjsis", catalog = "")
public class DanagerProject {
    private String rowId;
    private String bdId;
    private String bdName;
    private Timestamp createTime;
    private String projectAddress;
    private String fbProjectType;
    private String fbProjectName;
    private String fbProjectParameter;
    private String faSpQk;
    private Timestamp kgTime;
    private Timestamp wgTime;
    private String nowType;
    private String personCharge;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;

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
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "project_address")
    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    @Basic
    @Column(name = "fb_project_type")
    public String getFbProjectType() {
        return fbProjectType;
    }

    public void setFbProjectType(String fbProjectType) {
        this.fbProjectType = fbProjectType;
    }

    @Basic
    @Column(name = "fb_project_name")
    public String getFbProjectName() {
        return fbProjectName;
    }

    public void setFbProjectName(String fbProjectName) {
        this.fbProjectName = fbProjectName;
    }

    @Basic
    @Column(name = "fb_project_parameter")
    public String getFbProjectParameter() {
        return fbProjectParameter;
    }

    public void setFbProjectParameter(String fbProjectParameter) {
        this.fbProjectParameter = fbProjectParameter;
    }

    @Basic
    @Column(name = "fa_sp_qk")
    public String getFaSpQk() {
        return faSpQk;
    }

    public void setFaSpQk(String faSpQk) {
        this.faSpQk = faSpQk;
    }

    @Basic
    @Column(name = "kg_time")
    public Timestamp getKgTime() {
        return kgTime;
    }

    public void setKgTime(Timestamp kgTime) {
        this.kgTime = kgTime;
    }

    @Basic
    @Column(name = "wg_time")
    public Timestamp getWgTime() {
        return wgTime;
    }

    public void setWgTime(Timestamp wgTime) {
        this.wgTime = wgTime;
    }

    @Basic
    @Column(name = "now_type")
    public String getNowType() {
        return nowType;
    }

    public void setNowType(String nowType) {
        this.nowType = nowType;
    }

    @Basic
    @Column(name = "person_charge")
    public String getPersonCharge() {
        return personCharge;
    }

    public void setPersonCharge(String personCharge) {
        this.personCharge = personCharge;
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
    @Column(name = "ext5")
    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DanagerProject that = (DanagerProject) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (bdName != null ? !bdName.equals(that.bdName) : that.bdName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (projectAddress != null ? !projectAddress.equals(that.projectAddress) : that.projectAddress != null)
            return false;
        if (fbProjectType != null ? !fbProjectType.equals(that.fbProjectType) : that.fbProjectType != null)
            return false;
        if (fbProjectName != null ? !fbProjectName.equals(that.fbProjectName) : that.fbProjectName != null)
            return false;
        if (fbProjectParameter != null ? !fbProjectParameter.equals(that.fbProjectParameter) : that.fbProjectParameter != null)
            return false;
        if (faSpQk != null ? !faSpQk.equals(that.faSpQk) : that.faSpQk != null) return false;
        if (kgTime != null ? !kgTime.equals(that.kgTime) : that.kgTime != null) return false;
        if (wgTime != null ? !wgTime.equals(that.wgTime) : that.wgTime != null) return false;
        if (nowType != null ? !nowType.equals(that.nowType) : that.nowType != null) return false;
        if (personCharge != null ? !personCharge.equals(that.personCharge) : that.personCharge != null) return false;
        if (ext1 != null ? !ext1.equals(that.ext1) : that.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(that.ext3) : that.ext3 != null) return false;
        if (ext4 != null ? !ext4.equals(that.ext4) : that.ext4 != null) return false;
        if (ext5 != null ? !ext5.equals(that.ext5) : that.ext5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (projectAddress != null ? projectAddress.hashCode() : 0);
        result = 31 * result + (fbProjectType != null ? fbProjectType.hashCode() : 0);
        result = 31 * result + (fbProjectName != null ? fbProjectName.hashCode() : 0);
        result = 31 * result + (fbProjectParameter != null ? fbProjectParameter.hashCode() : 0);
        result = 31 * result + (faSpQk != null ? faSpQk.hashCode() : 0);
        result = 31 * result + (kgTime != null ? kgTime.hashCode() : 0);
        result = 31 * result + (wgTime != null ? wgTime.hashCode() : 0);
        result = 31 * result + (nowType != null ? nowType.hashCode() : 0);
        result = 31 * result + (personCharge != null ? personCharge.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        result = 31 * result + (ext4 != null ? ext4.hashCode() : 0);
        result = 31 * result + (ext5 != null ? ext5.hashCode() : 0);
        return result;
    }
}
