package com.gx.soft.process.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/5/30.
 */
@Entity
@Table(name = "proc_instance", schema = "njdtjsis", catalog = "")
public class ProcInstance {
    private String rowId;
    private String processId;
    private String processName;
    private String businessId;
    private String instanceState;
    private String activeState;
    private String activeUserName;
    private Timestamp timeLimit;
    private Timestamp createTime;
    private Timestamp endTime;
    private String createUserId;
    private String createUserName;
    private String dataType;
    private String dataStatus;
    private Integer dataOrder;
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
    @Column(name = "process_name")
    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
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
    @Column(name = "instance_state")
    public String getInstanceState() {
        return instanceState;
    }

    public void setInstanceState(String instanceState) {
        this.instanceState = instanceState;
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
    @Column(name = "active_user_name")
    public String getActiveUserName() {
        return activeUserName;
    }

    public void setActiveUserName(String activeUserName) {
        this.activeUserName = activeUserName;
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
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
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
    @Column(name = "create_user_name")
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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
    @Column(name = "data_order")
    public Integer getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Integer dataOrder) {
        this.dataOrder = dataOrder;
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

        ProcInstance that = (ProcInstance) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;
        if (processName != null ? !processName.equals(that.processName) : that.processName != null) return false;
        if (businessId != null ? !businessId.equals(that.businessId) : that.businessId != null) return false;
        if (instanceState != null ? !instanceState.equals(that.instanceState) : that.instanceState != null)
            return false;
        if (activeState != null ? !activeState.equals(that.activeState) : that.activeState != null) return false;
        if (activeUserName != null ? !activeUserName.equals(that.activeUserName) : that.activeUserName != null)
            return false;
        if (timeLimit != null ? !timeLimit.equals(that.timeLimit) : that.timeLimit != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (createUserName != null ? !createUserName.equals(that.createUserName) : that.createUserName != null)
            return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (dataDeleted != null ? !dataDeleted.equals(that.dataDeleted) : that.dataDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (processId != null ? processId.hashCode() : 0);
        result = 31 * result + (processName != null ? processName.hashCode() : 0);
        result = 31 * result + (businessId != null ? businessId.hashCode() : 0);
        result = 31 * result + (instanceState != null ? instanceState.hashCode() : 0);
        result = 31 * result + (activeState != null ? activeState.hashCode() : 0);
        result = 31 * result + (activeUserName != null ? activeUserName.hashCode() : 0);
        result = 31 * result + (timeLimit != null ? timeLimit.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (createUserName != null ? createUserName.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (dataDeleted != null ? dataDeleted.hashCode() : 0);
        return result;
    }
}
