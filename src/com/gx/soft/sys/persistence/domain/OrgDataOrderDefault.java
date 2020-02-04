package com.gx.soft.sys.persistence.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "org_data_order_default", schema = "njdtjsis", catalog = "")
public class OrgDataOrderDefault {
    private String rowId;
    private String orgId;
    private String orgName;
    private String pOrgId;
    private String oOrgName;
    private String dataOrder;
    private Integer ext1;
    private Date ext2;
    private String ext3;

    @Id
    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Basic
    @Column(name = "org_id")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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
    @Column(name = "p_org_id")
    public String getpOrgId() {
        return pOrgId;
    }

    public void setpOrgId(String pOrgId) {
        this.pOrgId = pOrgId;
    }

    @Basic
    @Column(name = "o_org_name")
    public String getoOrgName() {
        return oOrgName;
    }

    public void setoOrgName(String oOrgName) {
        this.oOrgName = oOrgName;
    }

    @Basic
    @Column(name = "data_order")
    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "ext1")
    public Integer getExt1() {
        return ext1;
    }

    public void setExt1(Integer ext1) {
        this.ext1 = ext1;
    }

    @Basic
    @Column(name = "ext2")
    public Date getExt2() {
        return ext2;
    }

    public void setExt2(Date ext2) {
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

        OrgDataOrderDefault that = (OrgDataOrderDefault) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (pOrgId != null ? !pOrgId.equals(that.pOrgId) : that.pOrgId != null) return false;
        if (oOrgName != null ? !oOrgName.equals(that.oOrgName) : that.oOrgName != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (ext1 != null ? !ext1.equals(that.ext1) : that.ext1 != null) return false;
        if (ext2 != null ? !ext2.equals(that.ext2) : that.ext2 != null) return false;
        if (ext3 != null ? !ext3.equals(that.ext3) : that.ext3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (orgId != null ? orgId.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (pOrgId != null ? pOrgId.hashCode() : 0);
        result = 31 * result + (oOrgName != null ? oOrgName.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (ext1 != null ? ext1.hashCode() : 0);
        result = 31 * result + (ext2 != null ? ext2.hashCode() : 0);
        result = 31 * result + (ext3 != null ? ext3.hashCode() : 0);
        return result;
    }
}
