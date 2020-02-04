package com.gx.soft.process.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by adminstrator on 2019/5/30.
 */
@Entity
@Table(name = "proc_act", schema = "njdtjsis", catalog = "")
public class ProcAct {
    private String rowId;
    private String processId;
    private String actId;
    private String actName;
    private String actExplain;
    private String handleUserName;
    private String handleUserName1;
    private String backAct;
    private String nextAct;
    private Integer actOrder;
    private String dataType;
    private String dataStatus;
    private String dataDeleted;

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
    @Column(name = "process_id")
    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Basic
    @Column(name = "act_id")
    public String getActId() {
        return actId;
    }

    public void setActId(String actId) {
        this.actId = actId;
    }

    @Basic
    @Column(name = "act_name")
    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    @Basic
    @Column(name = "act_explain")
    public String getActExplain() {
        return actExplain;
    }

    public void setActExplain(String actExplain) {
        this.actExplain = actExplain;
    }

    @Basic
    @Column(name = "handle_user_name")
    public String getHandleUserName() {
        return handleUserName;
    }

    public void setHandleUserName(String handleUserName) {
        this.handleUserName = handleUserName;
    }

    @Basic
    @Column(name = "handle_user_name1")
    public String getHandleUserName1() {
        return handleUserName1;
    }

    public void setHandleUserName1(String handleUserName1) {
        this.handleUserName1 = handleUserName1;
    }

    @Basic
    @Column(name = "back_act")
    public String getBackAct() {
        return backAct;
    }

    public void setBackAct(String backAct) {
        this.backAct = backAct;
    }

    @Basic
    @Column(name = "next_act")
    public String getNextAct() {
        return nextAct;
    }

    public void setNextAct(String nextAct) {
        this.nextAct = nextAct;
    }

    @Basic
    @Column(name = "act_order")
    public Integer getActOrder() {
        return actOrder;
    }

    public void setActOrder(Integer actOrder) {
        this.actOrder = actOrder;
    }

    @Basic
    @Column(name = "data_type")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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
    @Column(name = "data_deleted")
    public String getDataDeleted() {
        return dataDeleted;
    }

    public void setDataDeleted(String dataDeleted) {
        this.dataDeleted = dataDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcAct that = (ProcAct) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;
        if (actId != null ? !actId.equals(that.actId) : that.actId != null) return false;
        if (actName != null ? !actName.equals(that.actName) : that.actName != null) return false;
        if (actExplain != null ? !actExplain.equals(that.actExplain) : that.actExplain != null) return false;
        if (handleUserName != null ? !handleUserName.equals(that.handleUserName) : that.handleUserName != null)
            return false;
        if (handleUserName1 != null ? !handleUserName1.equals(that.handleUserName1) : that.handleUserName1 != null)
            return false;
        if (backAct != null ? !backAct.equals(that.backAct) : that.backAct != null) return false;
        if (nextAct != null ? !nextAct.equals(that.nextAct) : that.nextAct != null) return false;
        if (actOrder != null ? !actOrder.equals(that.actOrder) : that.actOrder != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataDeleted != null ? !dataDeleted.equals(that.dataDeleted) : that.dataDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (processId != null ? processId.hashCode() : 0);
        result = 31 * result + (actId != null ? actId.hashCode() : 0);
        result = 31 * result + (actName != null ? actName.hashCode() : 0);
        result = 31 * result + (actExplain != null ? actExplain.hashCode() : 0);
        result = 31 * result + (handleUserName != null ? handleUserName.hashCode() : 0);
        result = 31 * result + (handleUserName1 != null ? handleUserName1.hashCode() : 0);
        result = 31 * result + (backAct != null ? backAct.hashCode() : 0);
        result = 31 * result + (nextAct != null ? nextAct.hashCode() : 0);
        result = 31 * result + (actOrder != null ? actOrder.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataDeleted != null ? dataDeleted.hashCode() : 0);
        return result;
    }
}
