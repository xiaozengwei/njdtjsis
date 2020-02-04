package com.gx.soft.weeklyreport.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/9/2.
 */
@Entity
@Table(name = "dgj_jd", schema = "njdtjsis", catalog = "")
public class DgjJd {
    private String rowId;
    private String tjHs;
    private String yxYs;
    private Timestamp createTime;
    private Timestamp uploadTime;
    private String createUser;
    private String ext1;
    private String ext2;
    private String bdId;
    private String bdName;
    private Timestamp scTime;
    private String sjHs;
    private String klHs;
    private String ctCs;

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
    @Column(name = "tj_hs")
    public String getTjHs() {
        return tjHs;
    }

    public void setTjHs(String tjHs) {
        this.tjHs = tjHs;
    }

    @Basic
    @Column(name = "yx_ys")
    public String getYxYs() {
        return yxYs;
    }

    public void setYxYs(String yxYs) {
        this.yxYs = yxYs;
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
    @Column(name = "create_user")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
    @Column(name = "sc_time")
    public Timestamp getScTime() {
        return scTime;
    }

    public void setScTime(Timestamp scTime) {
        this.scTime = scTime;
    }

    @Basic
    @Column(name = "sj_hs")
    public String getSjHs() {
        return sjHs;
    }

    public void setSjHs(String sjHs) {
        this.sjHs = sjHs;
    }

    @Basic
    @Column(name = "kl_hs")
    public String getKlHs() {
        return klHs;
    }

    public void setKlHs(String klHs) {
        this.klHs = klHs;
    }

    @Basic
    @Column(name = "ct_cs")
    public String getCtCs() {
        return ctCs;
    }

    public void setCtCs(String ctCs) {
        this.ctCs = ctCs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DgjJd dgjJd = (DgjJd) o;

        if (rowId != null ? !rowId.equals(dgjJd.rowId) : dgjJd.rowId != null) return false;
        if (tjHs != null ? !tjHs.equals(dgjJd.tjHs) : dgjJd.tjHs != null) return false;
        if (yxYs != null ? !yxYs.equals(dgjJd.yxYs) : dgjJd.yxYs != null) return false;
        if (createTime != null ? !createTime.equals(dgjJd.createTime) : dgjJd.createTime != null) return false;
        if (uploadTime != null ? !uploadTime.equals(dgjJd.uploadTime) : dgjJd.uploadTime != null) return false;
        if (createUser != null ? !createUser.equals(dgjJd.createUser) : dgjJd.createUser != null) return false;
        if (ext1 != null ? !ext1.equals(dgjJd.ext1) : dgjJd.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(dgjJd.ext2) : dgjJd.ext2 != null) return false;
        if (bdId != null ? !bdId.equals(dgjJd.bdId) : dgjJd.bdId != null) return false;
        if (bdName != null ? !bdName.equals(dgjJd.bdName) : dgjJd.bdName != null) return false;
        if (scTime != null ? !scTime.equals(dgjJd.scTime) : dgjJd.scTime != null) return false;
        if (sjHs != null ? !sjHs.equals(dgjJd.sjHs) : dgjJd.sjHs != null) return false;
        if (klHs != null ? !klHs.equals(dgjJd.klHs) : dgjJd.klHs != null) return false;
        if (ctCs != null ? !ctCs.equals(dgjJd.ctCs) : dgjJd.ctCs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (tjHs != null ? tjHs.hashCode() : 0);
        result = 31 * result + (yxYs != null ? yxYs.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (scTime != null ? scTime.hashCode() : 0);
        result = 31 * result + (sjHs != null ? sjHs.hashCode() : 0);
        result = 31 * result + (klHs != null ? klHs.hashCode() : 0);
        result = 31 * result + (ctCs != null ? ctCs.hashCode() : 0);
        return result;
    }
}
