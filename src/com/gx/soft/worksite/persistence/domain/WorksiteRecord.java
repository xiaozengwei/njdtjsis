package com.gx.soft.worksite.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/13.
 */
@Entity
@Table(name = "worksite_record", schema = "njdtjsis", catalog = "")
public class WorksiteRecord {
    private String rowId;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String bdIntro;
    private String worksiteId;
    private String worksitName;
    private String bdId;
    private String status;
    private String bdName;
    private Integer orderNum;

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
    @Column(name = "bd_intro")
    public String getBdIntro() {
        return bdIntro;
    }

    public void setBdIntro(String bdIntro) {
        this.bdIntro = bdIntro;
    }

    @Basic
    @Column(name = "worksite_id")
    public String getWorksiteId() {
        return worksiteId;
    }

    public void setWorksiteId(String worksiteId) {
        this.worksiteId = worksiteId;
    }

    @Basic
    @Column(name = "worksit_name")
    public String getWorksitName() {
        return worksitName;
    }

    public void setWorksitName(String worksitName) {
        this.worksitName = worksitName;
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
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @Column(name = "order_num")
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorksiteRecord that = (WorksiteRecord) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (bdIntro != null ? !bdIntro.equals(that.bdIntro) : that.bdIntro != null) return false;
        if (worksiteId != null ? !worksiteId.equals(that.worksiteId) : that.worksiteId != null) return false;
        if (worksitName != null ? !worksitName.equals(that.worksitName) : that.worksitName != null) return false;
        if (bdId != null ? !bdId.equals(that.bdId) : that.bdId != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (bdName != null ? !bdName.equals(that.bdName) : that.bdName != null) return false;
        if (orderNum != null ? !orderNum.equals(that.orderNum) : that.orderNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (bdIntro != null ? bdIntro.hashCode() : 0);
        result = 31 * result + (worksiteId != null ? worksiteId.hashCode() : 0);
        result = 31 * result + (worksitName != null ? worksitName.hashCode() : 0);
        result = 31 * result + (bdId != null ? bdId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (bdName != null ? bdName.hashCode() : 0);
        result = 31 * result + (orderNum != null ? orderNum.hashCode() : 0);
        return result;
    }
}
