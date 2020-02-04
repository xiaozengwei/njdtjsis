package com.gx.soft.attendance.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gx_sys_score_rule", schema = "njdtjsis", catalog = "")
public class GxSysScoreRule {
    private String rowId;
    private Double scoreDefault;
    private Double scoreHalf;
    private Double scoreAll;
    private Double scoreLate;
    private Double scoreEarly;
    private Double scoreNormal;
    private String orgRowId;
    private String orgName;
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
    @Column(name = "score_default")
    public Double getScoreDefault() {
        return scoreDefault;
    }

    public void setScoreDefault(Double scoreDefault) {
        this.scoreDefault = scoreDefault;
    }

    @Basic
    @Column(name = "score_half")
    public Double getScoreHalf() {
        return scoreHalf;
    }

    public void setScoreHalf(Double scoreHalf) {
        this.scoreHalf = scoreHalf;
    }

    @Basic
    @Column(name = "score_all")
    public Double getScoreAll() {
        return scoreAll;
    }

    public void setScoreAll(Double scoreAll) {
        this.scoreAll = scoreAll;
    }

    @Basic
    @Column(name = "score_late")
    public Double getScoreLate() {
        return scoreLate;
    }

    public void setScoreLate(Double scoreLate) {
        this.scoreLate = scoreLate;
    }

    @Basic
    @Column(name = "score_early")
    public Double getScoreEarly() {
        return scoreEarly;
    }

    public void setScoreEarly(Double scoreEarly) {
        this.scoreEarly = scoreEarly;
    }

    @Basic
    @Column(name = "score_normal")
    public Double getScoreNormal() {
        return scoreNormal;
    }

    public void setScoreNormal(Double scoreNormal) {
        this.scoreNormal = scoreNormal;
    }

    @Basic
    @Column(name = "org_row_id")
    public String getOrgRowId() {
        return orgRowId;
    }

    public void setOrgRowId(String orgRowId) {
        this.orgRowId = orgRowId;
    }

    @Basic
    @Column(name = "org_name")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

        GxSysScoreRule that = (GxSysScoreRule) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (scoreDefault != null ? !scoreDefault.equals(that.scoreDefault) : that.scoreDefault != null) return false;
        if (scoreHalf != null ? !scoreHalf.equals(that.scoreHalf) : that.scoreHalf != null) return false;
        if (scoreAll != null ? !scoreAll.equals(that.scoreAll) : that.scoreAll != null) return false;
        if (scoreLate != null ? !scoreLate.equals(that.scoreLate) : that.scoreLate != null) return false;
        if (scoreEarly != null ? !scoreEarly.equals(that.scoreEarly) : that.scoreEarly != null) return false;
        if (scoreNormal != null ? !scoreNormal.equals(that.scoreNormal) : that.scoreNormal != null) return false;
        if (orgRowId != null ? !orgRowId.equals(that.orgRowId) : that.orgRowId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
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
        result = 31 * result + (scoreDefault != null ? scoreDefault.hashCode() : 0);
        result = 31 * result + (scoreHalf != null ? scoreHalf.hashCode() : 0);
        result = 31 * result + (scoreAll != null ? scoreAll.hashCode() : 0);
        result = 31 * result + (scoreLate != null ? scoreLate.hashCode() : 0);
        result = 31 * result + (scoreEarly != null ? scoreEarly.hashCode() : 0);
        result = 31 * result + (scoreNormal != null ? scoreNormal.hashCode() : 0);
        result = 31 * result + (orgRowId != null ? orgRowId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
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
