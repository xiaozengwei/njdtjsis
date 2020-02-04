package com.gx.soft.sys.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/20.
 */
@Entity
@Table(name = "gx_sys_org_tz", schema = "njdtjsis", catalog = "")
public class GxSysOrgTz {
    private String rowId;
    private String orgName;
    private String orgShowName;
    private String orgEnName;
    private String orgIntro;
    private Timestamp createTime;
    private String createUserId;
    private Timestamp modifyTime;
    private String modifyUserId;
    private String dataStatus;
    private Long dataOrder;
    private String parentOrgId;
    private String parentOrgName;
    private String orgType;
    private String isMainPage;
    private String orgBdId;
    private String orgBdName;
    private String orgComId;
    private String isShow;

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
    @Column(name = "org_name")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "org_show_name")
    public String getOrgShowName() {
        return orgShowName;
    }

    public void setOrgShowName(String orgShowName) {
        this.orgShowName = orgShowName;
    }

    @Basic
    @Column(name = "org_en_name")
    public String getOrgEnName() {
        return orgEnName;
    }

    public void setOrgEnName(String orgEnName) {
        this.orgEnName = orgEnName;
    }

    @Basic
    @Column(name = "org_intro")
    public String getOrgIntro() {
        return orgIntro;
    }

    public void setOrgIntro(String orgIntro) {
        this.orgIntro = orgIntro;
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
    @Column(name = "create_user_id")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "modify_time")
    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Basic
    @Column(name = "modify_user_id")
    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    @Basic
    @Column(name = "data_status")
    public String getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Basic
    @Column(name = "data_order")
    public Long getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Long dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "parent_org_id")
    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    @Basic
    @Column(name = "parent_org_name")
    public String getParentOrgName() {
        return parentOrgName;
    }

    public void setParentOrgName(String parentOrgName) {
        this.parentOrgName = parentOrgName;
    }

    @Basic
    @Column(name = "org_type")
    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @Basic
    @Column(name = "is_main_page")
    public String getIsMainPage() {
        return isMainPage;
    }

    public void setIsMainPage(String isMainPage) {
        this.isMainPage = isMainPage;
    }

    @Basic
    @Column(name = "org_bd_id")
    public String getOrgBdId() {
        return orgBdId;
    }

    public void setOrgBdId(String orgBdId) {
        this.orgBdId = orgBdId;
    }

    @Basic
    @Column(name = "org_bd_name")
    public String getOrgBdName() {
        return orgBdName;
    }

    public void setOrgBdName(String orgBdName) {
        this.orgBdName = orgBdName;
    }

    @Basic
    @Column(name = "org_com_id")
    public String getOrgComId() {
        return orgComId;
    }

    public void setOrgComId(String orgComId) {
        this.orgComId = orgComId;
    }

    @Basic
    @Column(name = "is_show")
    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GxSysOrgTz that = (GxSysOrgTz) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (orgShowName != null ? !orgShowName.equals(that.orgShowName) : that.orgShowName != null) return false;
        if (orgEnName != null ? !orgEnName.equals(that.orgEnName) : that.orgEnName != null) return false;
        if (orgIntro != null ? !orgIntro.equals(that.orgIntro) : that.orgIntro != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (modifyTime != null ? !modifyTime.equals(that.modifyTime) : that.modifyTime != null) return false;
        if (modifyUserId != null ? !modifyUserId.equals(that.modifyUserId) : that.modifyUserId != null) return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (parentOrgId != null ? !parentOrgId.equals(that.parentOrgId) : that.parentOrgId != null) return false;
        if (parentOrgName != null ? !parentOrgName.equals(that.parentOrgName) : that.parentOrgName != null)
            return false;
        if (orgType != null ? !orgType.equals(that.orgType) : that.orgType != null) return false;
        if (isMainPage != null ? !isMainPage.equals(that.isMainPage) : that.isMainPage != null) return false;
        if (orgBdId != null ? !orgBdId.equals(that.orgBdId) : that.orgBdId != null) return false;
        if (orgBdName != null ? !orgBdName.equals(that.orgBdName) : that.orgBdName != null) return false;
        if (orgComId != null ? !orgComId.equals(that.orgComId) : that.orgComId != null) return false;
        if (isShow != null ? !isShow.equals(that.isShow) : that.isShow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (orgShowName != null ? orgShowName.hashCode() : 0);
        result = 31 * result + (orgEnName != null ? orgEnName.hashCode() : 0);
        result = 31 * result + (orgIntro != null ? orgIntro.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (modifyTime != null ? modifyTime.hashCode() : 0);
        result = 31 * result + (modifyUserId != null ? modifyUserId.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (parentOrgId != null ? parentOrgId.hashCode() : 0);
        result = 31 * result + (parentOrgName != null ? parentOrgName.hashCode() : 0);
        result = 31 * result + (orgType != null ? orgType.hashCode() : 0);
        result = 31 * result + (isMainPage != null ? isMainPage.hashCode() : 0);
        result = 31 * result + (orgBdId != null ? orgBdId.hashCode() : 0);
        result = 31 * result + (orgBdName != null ? orgBdName.hashCode() : 0);
        result = 31 * result + (orgComId != null ? orgComId.hashCode() : 0);
        result = 31 * result + (isShow != null ? isShow.hashCode() : 0);
        return result;
    }
}
