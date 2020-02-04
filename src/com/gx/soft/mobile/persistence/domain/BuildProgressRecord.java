package com.gx.soft.mobile.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/7/30.
 */
@Entity
@Table(name = "build_progress_record", schema = "njdtjsis", catalog = "")
public class BuildProgressRecord {
    private String rowId;
    private String bdId;
    private String bdName;
    private String htPrice;
    private String htCost;
    private String costPrsent;
    private Integer dataOrder;
    private Timestamp createTime;
    private Timestamp uploadTime;
    private String ext1;
    private String ext2;
    private String ext3;

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
    @Column(name = "ht_price")
    public String getHtPrice() {
        return htPrice;
    }

    public void setHtPrice(String htPrice) {
        this.htPrice = htPrice;
    }

    @Basic
    @Column(name = "ht_cost")
    public String getHtCost() {
        return htCost;
    }

    public void setHtCost(String htCost) {
        this.htCost = htCost;
    }

    @Basic
    @Column(name = "cost_prsent")
    public String getCostPrsent() {
        return costPrsent;
    }

    public void setCostPrsent(String costPrsent) {
        this.costPrsent = costPrsent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuildProgressRecord that = (BuildProgressRecord) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (bdName != null ? !bdName.equals(that.bdName) : that.bdName != null) return false;
        if (htPrice != null ? !htPrice.equals(that.htPrice) : that.htPrice != null) return false;
        if (htCost != null ? !htCost.equals(that.htCost) : that.htCost != null) return false;
        if (costPrsent != null ? !costPrsent.equals(that.costPrsent) : that.costPrsent != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;
        if (ext1 != null ? !ext1.equals(that.ext1) : that.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(that.ext3) : that.ext3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (htPrice != null ? htPrice.hashCode() : 0);
        result = 31 * result + (htCost != null ? htCost.hashCode() : 0);
        result = 31 * result + (costPrsent != null ? costPrsent.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        return result;
    }
}
