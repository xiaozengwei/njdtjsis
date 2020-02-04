package com.gx.soft.process.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/4.
 */
@Entity
@Table(name = "v_dt_yc", schema = "njdtjsis", catalog = "")
public class VDtYc {
    private String businessId;
    private String applicantName;
    private String applicantPhone;
    private String applicantIdCard;
    private Timestamp startTime;
    private String createUserId;
    private String createUserName;
    private Timestamp createTime;
    private String processId;
    private String instanceId;
    private String instanceState;
    private String rowId;
    private String actId;
    private String actName;
    private String handleUser;
    private String handleUser1;
    private String actBack;
    private String actNext;
    private String activeState;
    private Timestamp activeTime;
    private Timestamp finishTime;
    private String stepState;

    @Id
    @Column(name = "business_id")
    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Basic
    @Column(name = "applicant_name")
    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    @Basic
    @Column(name = "applicant_phone")
    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    @Basic
    @Column(name = "applicant_id_card")
    public String getApplicantIdCard() {
        return applicantIdCard;
    }

    public void setApplicantIdCard(String applicantIdCard) {
        this.applicantIdCard = applicantIdCard;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
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
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
    @Column(name = "instance_state")
    public String getInstanceState() {
        return instanceState;
    }

    public void setInstanceState(String instanceState) {
        this.instanceState = instanceState;
    }

    @Basic
    @Column(name = "row_id")
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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
    @Column(name = "active_state")
    public String getActiveState() {
        return activeState;
    }

    public void setActiveState(String activeState) {
        this.activeState = activeState;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VDtYc that = (VDtYc) o;

        if (businessId != null ? !businessId.equals(that.businessId) : that.businessId != null) return false;
        if (applicantName != null ? !applicantName.equals(that.applicantName) : that.applicantName != null)
            return false;
        if (applicantPhone != null ? !applicantPhone.equals(that.applicantPhone) : that.applicantPhone != null)
            return false;
        if (applicantIdCard != null ? !applicantIdCard.equals(that.applicantIdCard) : that.applicantIdCard != null)
            return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (createUserName != null ? !createUserName.equals(that.createUserName) : that.createUserName != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (processId != null ? !processId.equals(that.processId) : that.processId != null) return false;
        if (instanceId != null ? !instanceId.equals(that.instanceId) : that.instanceId != null) return false;
        if (instanceState != null ? !instanceState.equals(that.instanceState) : that.instanceState != null)
            return false;
        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (actId != null ? !actId.equals(that.actId) : that.actId != null) return false;
        if (actName != null ? !actName.equals(that.actName) : that.actName != null) return false;
        if (handleUser != null ? !handleUser.equals(that.handleUser) : that.handleUser != null) return false;
        if (handleUser1 != null ? !handleUser1.equals(that.handleUser1) : that.handleUser1 != null) return false;
        if (actBack != null ? !actBack.equals(that.actBack) : that.actBack != null) return false;
        if (actNext != null ? !actNext.equals(that.actNext) : that.actNext != null) return false;
        if (activeState != null ? !activeState.equals(that.activeState) : that.activeState != null) return false;
        if (activeTime != null ? !activeTime.equals(that.activeTime) : that.activeTime != null) return false;
        if (finishTime != null ? !finishTime.equals(that.finishTime) : that.finishTime != null) return false;
        if (stepState != null ? !stepState.equals(that.stepState) : that.stepState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = businessId != null ? businessId.hashCode() : 0;
        result = 31 * result + (applicantName != null ? applicantName.hashCode() : 0);
        result = 31 * result + (applicantPhone != null ? applicantPhone.hashCode() : 0);
        result = 31 * result + (applicantIdCard != null ? applicantIdCard.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (createUserName != null ? createUserName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (processId != null ? processId.hashCode() : 0);
        result = 31 * result + (instanceId != null ? instanceId.hashCode() : 0);
        result = 31 * result + (instanceState != null ? instanceState.hashCode() : 0);
        result = 31 * result + (rowId != null ? rowId.hashCode() : 0);
        result = 31 * result + (actId != null ? actId.hashCode() : 0);
        result = 31 * result + (actName != null ? actName.hashCode() : 0);
        result = 31 * result + (handleUser != null ? handleUser.hashCode() : 0);
        result = 31 * result + (handleUser1 != null ? handleUser1.hashCode() : 0);
        result = 31 * result + (actBack != null ? actBack.hashCode() : 0);
        result = 31 * result + (actNext != null ? actNext.hashCode() : 0);
        result = 31 * result + (activeState != null ? activeState.hashCode() : 0);
        result = 31 * result + (activeTime != null ? activeTime.hashCode() : 0);
        result = 31 * result + (finishTime != null ? finishTime.hashCode() : 0);
        result = 31 * result + (stepState != null ? stepState.hashCode() : 0);
        return result;
    }
}
