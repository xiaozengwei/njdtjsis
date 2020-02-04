package com.gx.soft.restservice.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gx_sys_attendance", schema = "njdtjsis", catalog = "")
public class GxSysAttendance {
    private String uniqueId;
    private String attendancenNum;
    private String biddingsId;
    private String certificateNo;
    private String certificateType;
    private String doorControlName;
    private String id;
    private String imageUrl;
    private String projectId;
    private String restNum;
    private String signType;
    private String total;
    private String validCount;
    private Timestamp signTime;
    private Timestamp localRecordTime;

    @Id
    @Column(name = "uniqueId")
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Basic
    @Column(name = "attendancenNum")
    public String getAttendancenNum() {
        return attendancenNum;
    }

    public void setAttendancenNum(String attendancenNum) {
        this.attendancenNum = attendancenNum;
    }

    @Basic
    @Column(name = "biddingsId")
    public String getBiddingsId() {
        return biddingsId;
    }

    public void setBiddingsId(String biddingsId) {
        this.biddingsId = biddingsId;
    }

    @Basic
    @Column(name = "certificateNo")
    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    @Basic
    @Column(name = "certificateType")
    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    @Basic
    @Column(name = "doorControlName")
    public String getDoorControlName() {
        return doorControlName;
    }

    public void setDoorControlName(String doorControlName) {
        this.doorControlName = doorControlName;
    }

    @Basic
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "projectId")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "restNum")
    public String getRestNum() {
        return restNum;
    }

    public void setRestNum(String restNum) {
        this.restNum = restNum;
    }

    @Basic
    @Column(name = "signType")
    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Basic
    @Column(name = "total")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Basic
    @Column(name = "validCount")
    public String getValidCount() {
        return validCount;
    }

    public void setValidCount(String validCount) {
        this.validCount = validCount;
    }

    @Basic
    @Column(name = "signTime")
    public Timestamp getSignTime() {
        return signTime;
    }

    public void setSignTime(Timestamp signTime) {
        this.signTime = signTime;
    }

    @Basic
    @Column(name = "localRecordTime")
    public Timestamp getLocalRecordTime() {
        return localRecordTime;
    }

    public void setLocalRecordTime(Timestamp localRecordTime) {
        this.localRecordTime = localRecordTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GxSysAttendance that = (GxSysAttendance) o;

        if (uniqueId != null ? !uniqueId.equals(that.uniqueId) : that.uniqueId != null) return false;
        if (attendancenNum != null ? !attendancenNum.equals(that.attendancenNum) : that.attendancenNum != null)
            return false;
        if (biddingsId != null ? !biddingsId.equals(that.biddingsId) : that.biddingsId != null) return false;
        if (certificateNo != null ? !certificateNo.equals(that.certificateNo) : that.certificateNo != null)
            return false;
        if (certificateType != null ? !certificateType.equals(that.certificateType) : that.certificateType != null)
            return false;
        if (doorControlName != null ? !doorControlName.equals(that.doorControlName) : that.doorControlName != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (restNum != null ? !restNum.equals(that.restNum) : that.restNum != null) return false;
        if (signType != null ? !signType.equals(that.signType) : that.signType != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (validCount != null ? !validCount.equals(that.validCount) : that.validCount != null) return false;
        if (signTime != null ? !signTime.equals(that.signTime) : that.signTime != null) return false;
        if (localRecordTime != null ? !localRecordTime.equals(that.localRecordTime) : that.localRecordTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uniqueId != null ? uniqueId.hashCode() : 0;
        result = 31 * result + (attendancenNum != null ? attendancenNum.hashCode() : 0);
        result = 31 * result + (biddingsId != null ? biddingsId.hashCode() : 0);
        result = 31 * result + (certificateNo != null ? certificateNo.hashCode() : 0);
        result = 31 * result + (certificateType != null ? certificateType.hashCode() : 0);
        result = 31 * result + (doorControlName != null ? doorControlName.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (restNum != null ? restNum.hashCode() : 0);
        result = 31 * result + (signType != null ? signType.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (validCount != null ? validCount.hashCode() : 0);
        result = 31 * result + (signTime != null ? signTime.hashCode() : 0);
        result = 31 * result + (localRecordTime != null ? localRecordTime.hashCode() : 0);
        return result;
    }
}
