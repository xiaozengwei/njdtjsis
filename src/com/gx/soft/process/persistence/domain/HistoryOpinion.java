package com.gx.soft.process.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/4.
 */
@Entity
@Table(name = "history_opinion", schema = "njdtjsis", catalog = "")
public class HistoryOpinion {
    private String rowId;
    private String tableId;
    private String piId;
    private String handleStage;
    private String handleProcess;
    private String handleUser;
    private Timestamp handleTime;
    private String handleOpinion;
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
    @Column(name = "table_id")
    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "pi_id")
    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    @Basic
    @Column(name = "handle_stage")
    public String getHandleStage() {
        return handleStage;
    }

    public void setHandleStage(String handleStage) {
        this.handleStage = handleStage;
    }

    @Basic
    @Column(name = "handle_process")
    public String getHandleProcess() {
        return handleProcess;
    }

    public void setHandleProcess(String handleProcess) {
        this.handleProcess = handleProcess;
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
    @Column(name = "handle_time")
    public Timestamp getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Timestamp handleTime) {
        this.handleTime = handleTime;
    }

    @Basic
    @Column(name = "handle_opinion")
    public String getHandleOpinion() {
        return handleOpinion;
    }

    public void setHandleOpinion(String handleOpinion) {
        this.handleOpinion = handleOpinion;
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

        HistoryOpinion that = (HistoryOpinion) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (tableId != null ? !tableId.equals(that.tableId) : that.tableId != null) return false;
        if (piId != null ? !piId.equals(that.piId) : that.piId != null) return false;
        if (handleStage != null ? !handleStage.equals(that.handleStage) : that.handleStage != null) return false;
        if (handleProcess != null ? !handleProcess.equals(that.handleProcess) : that.handleProcess != null)
            return false;
        if (handleUser != null ? !handleUser.equals(that.handleUser) : that.handleUser != null) return false;
        if (handleTime != null ? !handleTime.equals(that.handleTime) : that.handleTime != null) return false;
        if (handleOpinion != null ? !handleOpinion.equals(that.handleOpinion) : that.handleOpinion != null)
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
        result = 31 * result + (tableId != null ? tableId.hashCode() : 0);
        result = 31 * result + (piId != null ? piId.hashCode() : 0);
        result = 31 * result + (handleStage != null ? handleStage.hashCode() : 0);
        result = 31 * result + (handleProcess != null ? handleProcess.hashCode() : 0);
        result = 31 * result + (handleUser != null ? handleUser.hashCode() : 0);
        result = 31 * result + (handleTime != null ? handleTime.hashCode() : 0);
        result = 31 * result + (handleOpinion != null ? handleOpinion.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (dataDeleted != null ? dataDeleted.hashCode() : 0);
        return result;
    }
}
