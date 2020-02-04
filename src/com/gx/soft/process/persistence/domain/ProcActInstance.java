package com.gx.soft.process.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/5/30.
 */
@Entity
@Table(name = "proc_act_instance", schema = "njdtjsis", catalog = "")
public class ProcActInstance {
    private String rowId;
    private String processId;
    private String instanceId;
    private String businessId;
    private String actId;
    private String actName;
    private String handleUser;
    private String handleUser1;
    private String actBack;
    private String actNext;
    private Integer actOrder;
    private String actInstRemark;
    private String activeState;
    private String activeUserId;
    private String activeUserName;
    private Timestamp activeTime;
    private Timestamp finishTime;
    private String stepState;
    private Timestamp timeLimit;
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
    @Column(name = "instance_id")
    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Basic
    @Column(name = "business_id")
    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
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
    @Column(name = "handle_user")
    public String getHandleUser() {
        return handleUser;
    }

    public void setHandleUser(String handleUser) {
        this.handleUser = handleUser;
    }

    @Basic
    @Column(name = "handle_user1")
    public String getHandleUser1() {
        return handleUser1;
    }

    public void setHandleUser1(String handleUser1) {
        this.handleUser1 = handleUser1;
    }

    @Basic
    @Column(name = "act_back")
    public String getActBack() {
        return actBack;
    }

    public void setActBack(String actBack) {
        this.actBack = actBack;
    }

    @Basic
    @Column(name = "act_next")
    public String getActNext() {
        return actNext;
    }

    public void setActNext(String actNext) {
        this.actNext = actNext;
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
    @Column(name = "act_inst_remark")
    public String getActInstRemark() {
        return actInstRemark;
    }

    public void setActInstRemark(String actInstRemark) {
        this.actInstRemark = actInstRemark;
    }

    @Basic
    @Column(name = "active_state")
    public String getActiveState() {
        return activeState;
    }

    public void setActiveState(String activeState) {
        this.activeState = activeState;
    }

    @Basic
    @Column(name = "active_user_id")
    public String getActiveUserId() {
        return activeUserId;
    }

    public void setActiveUserId(String activeUserId) {
        this.activeUserId = activeUserId;
    }

    @Basic
    @Column(name = "active_user_name")
    public String getActiveUserName() {
        return activeUserName;
    }

    public void setActiveUserName(String activeUserName) {
        this.activeUserName = activeUserName;
    }

    @Basic
    @Column(name = "active_time")
    public Timestamp getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = activeTime;
    }

    @Basic
    @Column(name = "finish_time")
    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Basic
    @Column(name = "step_state")
    public String getStepState() {
        return stepState;
    }

    public void setStepState(String stepState) {
        this.stepState = stepState;
    }

    @Basic
    @Column(name = "time_limit")
    public Timestamp getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Timestamp timeLimit) {
        this.timeLimit = timeLimit;
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

        ProcActInstance that = (ProcActInstance) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;
        if (instanceId != null ? !instanceId.equals(that.instanceId) : that.instanceId != null) return false;
        if (businessId != null ? !businessId.equals(that.businessId) : that.businessId != null) return false;
        if (actId != null ? !actId.equals(that.actId) : that.actId != null) return false;
        if (actName != null ? !actName.equals(that.actName) : that.actName != null) return false;
        if (handleUser != null ? !handleUser.equals(that.handleUser) : that.handleUser != null) return false;
        if (handleUser1 != null ? !handleUser1.equals(that.handleUser1) : that.handleUser1 != null) return false;
        if (actBack != null ? !actBack.equals(that.actBack) : that.actBack != null) return false;
        if (actNext != null ? !actNext.equals(that.actNext) : that.actNext != null) return false;
        if (actOrder != null ? !actOrder.equals(that.actOrder) : that.actOrder != null) return false;
        if (actInstRemark != null ? !actInstRemark.equals(that.actInstRemark) : that.actInstRemark != null)
            return false;
        if (activeState != null ? !activeState.equals(that.activeState) : that.activeState != null) return false;
        if (activeUserId != null ? !activeUserId.equals(that.activeUserId) : that.activeUserId != null) return false;
        if (activeUserName != null ? !activeUserName.equals(that.activeUserName) : that.activeUserName != null)
            return false;
        if (activeTime != null ? !activeTime.equals(that.activeTime) : that.activeTime != null) return false;
        if (finishTime != null ? !finishTime.equals(that.finishTime) : that.finishTime != null) return false;
        if (stepState != null ? !stepState.equals(that.stepState) : that.stepState != null) return false;
        if (timeLimit != null ? !timeLimit.equals(that.timeLimit) : that.timeLimit != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataDeleted != null ? !dataDeleted.equals(that.dataDeleted) : that.dataDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (processId != null ? processId.hashCode() : 0);
        result = 31 * result + (instanceId != null ? instanceId.hashCode() : 0);
        result = 31 * result + (businessId != null ? businessId.hashCode() : 0);
        result = 31 * result + (actId != null ? actId.hashCode() : 0);
        result = 31 * result + (actName != null ? actName.hashCode() : 0);
        result = 31 * result + (handleUser != null ? handleUser.hashCode() : 0);
        result = 31 * result + (handleUser1 != null ? handleUser1.hashCode() : 0);
        result = 31 * result + (actBack != null ? actBack.hashCode() : 0);
        result = 31 * result + (actNext != null ? actNext.hashCode() : 0);
        result = 31 * result + (actOrder != null ? actOrder.hashCode() : 0);
        result = 31 * result + (actInstRemark != null ? actInstRemark.hashCode() : 0);
        result = 31 * result + (activeState != null ? activeState.hashCode() : 0);
        result = 31 * result + (activeUserId != null ? activeUserId.hashCode() : 0);
        result = 31 * result + (activeUserName != null ? activeUserName.hashCode() : 0);
        result = 31 * result + (activeTime != null ? activeTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (stepState != null ? stepState.hashCode() : 0);
        result = 31 * result + (timeLimit != null ? timeLimit.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataDeleted != null ? dataDeleted.hashCode() : 0);
        return result;
    }
}
