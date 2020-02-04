package com.gx.soft.process.persistence.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by adminstrator on 2019/6/3.
 */
@Entity
@Table(name = "attachment", schema = "njdtjsis", catalog = "")
public class Attachment {
    private String rowId;
    private String relationId;
    private String fileName;
    private String fileType;
    private String fileIdentifyName;
    private String filePath;
    private String uploadUserId;
    private String uploadUserName;
    private Timestamp uploadTime;
    private String dataStatus;
    private String dataOrder;
    private String dataDelete;
    private String fileLongitude;
    private String fileDimensionality;

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
    @Column(name = "relation_id")
    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_type")
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Basic
    @Column(name = "file_identify_name")
    public String getFileIdentifyName() {
        return fileIdentifyName;
    }

    public void setFileIdentifyName(String fileIdentifyName) {
        this.fileIdentifyName = fileIdentifyName;
    }

    @Basic
    @Column(name = "file_path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "upload_user_id")
    public String getUploadUserId() {
        return uploadUserId;
    }

    public void setUploadUserId(String uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    @Basic
    @Column(name = "upload_user_name")
    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
    }

    @Basic
    @Column(name = "upload_time")
    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
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
    public String getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Basic
    @Column(name = "data_delete")
    public String getDataDelete() {
        return dataDelete;
    }

    public void setDataDelete(String dataDelete) {
        this.dataDelete = dataDelete;
    }

    @Basic
    @Column(name = "file_longitude")
    public String getFileLongitude() {
        return fileLongitude;
    }

    public void setFileLongitude(String fileLongitude) {
        this.fileLongitude = fileLongitude;
    }

    @Basic
    @Column(name = "file_dimensionality")
    public String getFileDimensionality() {
        return fileDimensionality;
    }

    public void setFileDimensionality(String fileDimensionality) {
        this.fileDimensionality = fileDimensionality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (rowId != null ? !rowId.equals(that.rowId) : that.rowId != null) return false;
        if (relationId != null ? !relationId.equals(that.relationId) : that.relationId != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (fileType != null ? !fileType.equals(that.fileType) : that.fileType != null) return false;
        if (fileIdentifyName != null ? !fileIdentifyName.equals(that.fileIdentifyName) : that.fileIdentifyName != null)
            return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (uploadUserId != null ? !uploadUserId.equals(that.uploadUserId) : that.uploadUserId != null) return false;
        if (uploadUserName != null ? !uploadUserName.equals(that.uploadUserName) : that.uploadUserName != null)
            return false;
        if (uploadTime != null ? !uploadTime.equals(that.uploadTime) : that.uploadTime != null) return false;
        if (dataStatus != null ? !dataStatus.equals(that.dataStatus) : that.dataStatus != null) return false;
        if (dataOrder != null ? !dataOrder.equals(that.dataOrder) : that.dataOrder != null) return false;
        if (dataDelete != null ? !dataDelete.equals(that.dataDelete) : that.dataDelete != null) return false;
        if (fileLongitude != null ? !fileLongitude.equals(that.fileLongitude) : that.fileLongitude != null)
            return false;
        if (fileDimensionality != null ? !fileDimensionality.equals(that.fileDimensionality) : that.fileDimensionality != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rowId != null ? rowId.hashCode() : 0;
        result = 31 * result + (relationId != null ? relationId.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (fileType != null ? fileType.hashCode() : 0);
        result = 31 * result + (fileIdentifyName != null ? fileIdentifyName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (uploadUserId != null ? uploadUserId.hashCode() : 0);
        result = 31 * result + (uploadUserName != null ? uploadUserName.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + (dataStatus != null ? dataStatus.hashCode() : 0);
        result = 31 * result + (dataOrder != null ? dataOrder.hashCode() : 0);
        result = 31 * result + (dataDelete != null ? dataDelete.hashCode() : 0);
        result = 31 * result + (fileLongitude != null ? fileLongitude.hashCode() : 0);
        result = 31 * result + (fileDimensionality != null ? fileDimensionality.hashCode() : 0);
        return result;
    }
}
