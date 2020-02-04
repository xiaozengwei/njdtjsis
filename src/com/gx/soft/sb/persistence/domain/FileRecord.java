package com.gx.soft.sb.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * FileRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "file_record", catalog = "njdtjsis")
public class FileRecord implements java.io.Serializable {

	// Fields

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

	// Constructors

	/** default constructor */
	public FileRecord() {
	}

	/** full constructor */
	public FileRecord(String relationId, String fileName, String fileType,
			String fileIdentifyName, String filePath, String uploadUserId,
			String uploadUserName, Timestamp uploadTime, String dataStatus,
			String dataOrder, String dataDelete) {
		this.relationId = relationId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileIdentifyName = fileIdentifyName;
		this.filePath = filePath;
		this.uploadUserId = uploadUserId;
		this.uploadUserName = uploadUserName;
		this.uploadTime = uploadTime;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.dataDelete = dataDelete;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "row_id", unique = true, nullable = false, length = 40)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "relation_id", length = 40)
	public String getRelationId() {
		return this.relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	@Column(name = "file_name", length = 100)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_type", length = 40)
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Column(name = "file_identify_name", length = 100)
	public String getFileIdentifyName() {
		return this.fileIdentifyName;
	}

	public void setFileIdentifyName(String fileIdentifyName) {
		this.fileIdentifyName = fileIdentifyName;
	}

	@Column(name = "file_path", length = 100)
	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "upload_user_id", length = 40)
	public String getUploadUserId() {
		return this.uploadUserId;
	}

	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

	@Column(name = "upload_user_name", length = 40)
	public String getUploadUserName() {
		return this.uploadUserName;
	}

	public void setUploadUserName(String uploadUserName) {
		this.uploadUserName = uploadUserName;
	}

	@Column(name = "upload_time", length = 19)
	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_order", length = 40)
	public String getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(String dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "data_delete", length = 40)
	public String getDataDelete() {
		return this.dataDelete;
	}

	public void setDataDelete(String dataDelete) {
		this.dataDelete = dataDelete;
	}

}