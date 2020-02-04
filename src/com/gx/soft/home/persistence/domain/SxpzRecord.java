package com.gx.soft.home.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/4.
 */
@Entity
@Table(name = "sxpz_record", schema = "njdtjsis", catalog = "")
public class SxpzRecord {
    private String rowId;
    private String sxpzId;
    private String sxpzName;
    private String sxpzComId;
    private String sxpzBdId;
    private String sxpzComName;
    private String sxpzStatus;
    private Integer sxpzOrder;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String v1;
    private String v2;
    private String v3;
    private String v4;
    private String v5;
    private String h1;
    private String h2;
    private String h3;
    private String h4;
    private String h5;
    private String bdIntro;
    private String b1;
    private String b2;
    private String v6;
    private String v7;

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
    @Column(name = "sxpz_id")
    public String getSxpzId() {
        return sxpzId;
    }

    public void setSxpzId(String sxpzId) {
        this.sxpzId = sxpzId;
    }

    @Basic
    @Column(name = "sxpz_name")
    public String getSxpzName() {
        return sxpzName;
    }

    public void setSxpzName(String sxpzName) {
        this.sxpzName = sxpzName;
    }

    @Basic
    @Column(name = "sxpz_com_id")
    public String getSxpzComId() {
        return sxpzComId;
    }

    public void setSxpzComId(String sxpzComId) {
        this.sxpzComId = sxpzComId;
    }

    @Basic
    @Column(name = "sxpz_bd_id")
    public String getSxpzBdId() {
        return sxpzBdId;
    }

    public void setSxpzBdId(String sxpzBdId) {
        this.sxpzBdId = sxpzBdId;
    }

    @Basic
    @Column(name = "sxpz_com_name")
    public String getSxpzComName() {
        return sxpzComName;
    }

    public void setSxpzComName(String sxpzComName) {
        this.sxpzComName = sxpzComName;
    }

    @Basic
    @Column(name = "sxpz_status")
    public String getSxpzStatus() {
        return sxpzStatus;
    }

    public void setSxpzStatus(String sxpzStatus) {
        this.sxpzStatus = sxpzStatus;
    }

    @Basic
    @Column(name = "sxpz_order")
    public Integer getSxpzOrder() {
        return sxpzOrder;
    }

    public void setSxpzOrder(Integer sxpzOrder) {
        this.sxpzOrder = sxpzOrder;
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
    @Column(name = "v1")
    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    @Basic
    @Column(name = "v2")
    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    @Basic
    @Column(name = "v3")
    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    @Basic
    @Column(name = "v4")
    public String getV4() {
        return v4;
    }

    public void setV4(String v4) {
        this.v4 = v4;
    }

    @Basic
    @Column(name = "v5")
    public String getV5() {
        return v5;
    }

    public void setV5(String v5) {
        this.v5 = v5;
    }

    @Basic
    @Column(name = "h1")
    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    @Basic
    @Column(name = "h2")
    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    @Basic
    @Column(name = "h3")
    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    @Basic
    @Column(name = "h4")
    public String getH4() {
        return h4;
    }

    public void setH4(String h4) {
        this.h4 = h4;
    }

    @Basic
    @Column(name = "h5")
    public String getH5() {
        return h5;
    }

    public void setH5(String h5) {
        this.h5 = h5;
    }

    @Basic
    @Column(name = "bd_intro")
    public String getBdIntro() {
        return bdIntro;
    }

    public void setBdIntro(String bdIntro) {
        this.bdIntro = bdIntro;
    }

    @Basic
    @Column(name = "b1")
    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    @Basic
    @Column(name = "b2")
    public String getB2() {
        return b2;
    }

    public void setB2(String b2) {
        this.b2 = b2;
    }

    @Basic
    @Column(name = "v6")
    public String getV6() {
        return v6;
    }

    public void setV6(String v6) {
        this.v6 = v6;
    }

    @Basic
    @Column(name = "v7")
    public String getV7() {
        return v7;
    }

    public void setV7(String v7) {
        this.v7 = v7;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SxpzRecord that = (SxpzRecord) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (sxpzId != null ? !sxpzId.equals(that.sxpzId) : that.sxpzId != null) return false;
        if (sxpzName != null ? !sxpzName.equals(that.sxpzName) : that.sxpzName != null) return false;
        if (sxpzComId != null ? !sxpzComId.equals(that.sxpzComId) : that.sxpzComId != null) return false;
        if (sxpzBdId != null ? !sxpzBdId.equals(that.sxpzBdId) : that.sxpzBdId != null) return false;
        if (sxpzComName != null ? !sxpzComName.equals(that.sxpzComName) : that.sxpzComName != null) return false;
        if (sxpzStatus != null ? !sxpzStatus.equals(that.sxpzStatus) : that.sxpzStatus != null) return false;
        if (sxpzOrder != null ? !sxpzOrder.equals(that.sxpzOrder) : that.sxpzOrder != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (v1 != null ? !v1.equals(that.v1) : that.v1 != null) return false;
        if (v2 != null ? !v2.equals(that.v2) : that.v2 != null) return false;
        if (v3 != null ? !v3.equals(that.v3) : that.v3 != null) return false;
        if (v4 != null ? !v4.equals(that.v4) : that.v4 != null) return false;
        if (v5 != null ? !v5.equals(that.v5) : that.v5 != null) return false;
        if (h1 != null ? !h1.equals(that.h1) : that.h1 != null) return false;
        if (h2 != null ? !h2.equals(that.h2) : that.h2 != null) return false;
        if (h3 != null ? !h3.equals(that.h3) : that.h3 != null) return false;
        if (h4 != null ? !h4.equals(that.h4) : that.h4 != null) return false;
        if (h5 != null ? !h5.equals(that.h5) : that.h5 != null) return false;
        if (bdIntro != null ? !bdIntro.equals(that.bdIntro) : that.bdIntro != null) return false;
        if (b1 != null ? !b1.equals(that.b1) : that.b1 != null) return false;
        if (b2 != null ? !b2.equals(that.b2) : that.b2 != null) return false;
        if (v6 != null ? !v6.equals(that.v6) : that.v6 != null) return false;
        if (v7 != null ? !v7.equals(that.v7) : that.v7 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (sxpzId != null ? sxpzId.hashCode() : 0);
        result = 31 * result + (sxpzName != null ? sxpzName.hashCode() : 0);
        result = 31 * result + (sxpzComId != null ? sxpzComId.hashCode() : 0);
        result = 31 * result + (sxpzBdId != null ? sxpzBdId.hashCode() : 0);
        result = 31 * result + (sxpzComName != null ? sxpzComName.hashCode() : 0);
        result = 31 * result + (sxpzStatus != null ? sxpzStatus.hashCode() : 0);
        result = 31 * result + (sxpzOrder != null ? sxpzOrder.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (v1 != null ? v1.hashCode() : 0);
        result = 31 * result + (v2 != null ? v2.hashCode() : 0);
        result = 31 * result + (v3 != null ? v3.hashCode() : 0);
        result = 31 * result + (v4 != null ? v4.hashCode() : 0);
        result = 31 * result + (v5 != null ? v5.hashCode() : 0);
        result = 31 * result + (h1 != null ? h1.hashCode() : 0);
        result = 31 * result + (h2 != null ? h2.hashCode() : 0);
        result = 31 * result + (h3 != null ? h3.hashCode() : 0);
        result = 31 * result + (h4 != null ? h4.hashCode() : 0);
        result = 31 * result + (h5 != null ? h5.hashCode() : 0);
        result = 31 * result + (bdIntro != null ? bdIntro.hashCode() : 0);
        result = 31 * result + (b1 != null ? b1.hashCode() : 0);
        result = 31 * result + (b2 != null ? b2.hashCode() : 0);
        result = 31 * result + (v6 != null ? v6.hashCode() : 0);
        result = 31 * result + (v7 != null ? v7.hashCode() : 0);
        return result;
    }
}
