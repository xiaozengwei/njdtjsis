package com.gx.soft.restservice.persistence.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "attendance_record_time", schema = "njdtjsis", catalog = "")
public class AttendanceRecordTime {
    private String id;
    private Timestamp recordTime;
    private Timestamp localRecordTime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "recordTime")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
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

        AttendanceRecordTime that = (AttendanceRecordTime) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (recordTime != null ? !recordTime.equals(that.recordTime) : that.recordTime != null) return false;
        if (localRecordTime != null ? !localRecordTime.equals(that.localRecordTime) : that.localRecordTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (recordTime != null ? recordTime.hashCode() : 0);
        result = 31 * result + (localRecordTime != null ? localRecordTime.hashCode() : 0);
        return result;
    }
}
