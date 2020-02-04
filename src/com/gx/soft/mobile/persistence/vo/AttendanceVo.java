package com.gx.soft.mobile.persistence.vo;

public class AttendanceVo {
    private String timeA;
    private String userName;
    private String orgName;
    private String rule;
    private String morning;
    private String evening;
    private String count;
    private String timeLength;
    private String status;
    private String result;
    private String resultChange;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTimeA() {
        return timeA;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getEvening() {
        return evening;
    }

    public void setEvening(String evening) {
        this.evening = evening;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultChange() {
        return resultChange;
    }

    public void setResultChange(String resultChange) {
        this.resultChange = resultChange;
    }

    public AttendanceVo(String timeA, String userName, String orgName, String rule, String morning, String evening, String count, String timeLength, String status, String result, String resultChange) {
        this.timeA = timeA;
        this.userName = userName;
        this.orgName = orgName;
        this.rule = rule;
        this.morning = morning;
        this.evening = evening;
        this.count = count;
        this.timeLength = timeLength;
        this.status = status;
        this.result = result;
        this.resultChange = resultChange;
    }
    public AttendanceVo(){

    }
}
