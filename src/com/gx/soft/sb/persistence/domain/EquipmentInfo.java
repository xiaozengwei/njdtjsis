package com.gx.soft.sb.persistence.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * EquipmentInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "equipment_info", catalog = "njdtjsis")
public class EquipmentInfo implements java.io.Serializable {

	// Fields

	private String rowId;
	private String equipmentType;
	private String equipmentName;
	private String equipmentModel;
	private String driverName;
	private String telephone;
	private String lsDw;
	private String managerNum;
	private Date enterTime;
	private Date outerTime;
	private String operationLicense;
	private String isTest;
	private String workStatus;
	private String customMessage;
	private Timestamp createTime;
	private String createUserId;
	private String createUserName;
	private Timestamp updateTime;
	private String updateUserId;
	private String updateUserName;
	private String dataStatus;
	private Integer dataOrder;
	private String ext1;
	private Timestamp ext2;
	private Integer ext3;
	private String orgDwId;
	private String qrCode;
	private String bdId;
	private String sbZl;

	// Constructors

	/** default constructor */
	public EquipmentInfo() {
	}

	/** full constructor */
	public EquipmentInfo(String equipmentType, String equipmentName,
			String equipmentModel, String driverName, String telephone,
			String lsDw, String managerNum, Date enterTime, Date outerTime,
			String operationLicense, String isTest, String workStatus,
			String customMessage, Timestamp createTime, String createUserId,
			String createUserName, Timestamp updateTime, String updateUserId,
			String updateUserName, String dataStatus, Integer dataOrder,
			String ext1, Timestamp ext2, Integer ext3, String orgDwId,
			String qrCode, String bdId, String sbZl) {
		this.equipmentType = equipmentType;
		this.equipmentName = equipmentName;
		this.equipmentModel = equipmentModel;
		this.driverName = driverName;
		this.telephone = telephone;
		this.lsDw = lsDw;
		this.managerNum = managerNum;
		this.enterTime = enterTime;
		this.outerTime = outerTime;
		this.operationLicense = operationLicense;
		this.isTest = isTest;
		this.workStatus = workStatus;
		this.customMessage = customMessage;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.ext3 = ext3;
		this.orgDwId = orgDwId;
		this.qrCode = qrCode;
		this.bdId = bdId;
		this.sbZl = sbZl;
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

	@Column(name = "equipment_type", length = 40)
	public String getEquipmentType() {
		return this.equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	@Column(name = "equipment_name", length = 40)
	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "equipment_model", length = 40)
	public String getEquipmentModel() {
		return this.equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	@Column(name = "driver_name", length = 40)
	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@Column(name = "telephone", length = 40)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "ls_dw", length = 40)
	public String getLsDw() {
		return this.lsDw;
	}

	public void setLsDw(String lsDw) {
		this.lsDw = lsDw;
	}

	@Column(name = "manager_num", length = 40)
	public String getManagerNum() {
		return this.managerNum;
	}

	public void setManagerNum(String managerNum) {
		this.managerNum = managerNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "enter_time", length = 10)
	public Date getEnterTime() {
		return this.enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "outer_time", length = 10)
	public Date getOuterTime() {
		return this.outerTime;
	}

	public void setOuterTime(Date outerTime) {
		this.outerTime = outerTime;
	}

	@Column(name = "operation_license", length = 40)
	public String getOperationLicense() {
		return this.operationLicense;
	}

	public void setOperationLicense(String operationLicense) {
		this.operationLicense = operationLicense;
	}

	@Column(name = "is_test", length = 40)
	public String getIsTest() {
		return this.isTest;
	}

	public void setIsTest(String isTest) {
		this.isTest = isTest;
	}

	@Column(name = "work_status", length = 40)
	public String getWorkStatus() {
		return this.workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	@Column(name = "custom_message", length = 200)
	public String getCustomMessage() {
		return this.customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_user_id", length = 40)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "create_user_name", length = 40)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Column(name = "update_time", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "update_user_id", length = 40)
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@Column(name = "update_user_name", length = 40)
	public String getUpdateUserName() {
		return this.updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_order")
	public Integer getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(Integer dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "ext1", length = 40)
	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	@Column(name = "ext2", length = 19)
	public Timestamp getExt2() {
		return this.ext2;
	}

	public void setExt2(Timestamp ext2) {
		this.ext2 = ext2;
	}

	@Column(name = "ext3")
	public Integer getExt3() {
		return this.ext3;
	}

	public void setExt3(Integer ext3) {
		this.ext3 = ext3;
	}

	@Column(name = "org_dw_id", length = 40)
	public String getOrgDwId() {
		return this.orgDwId;
	}

	public void setOrgDwId(String orgDwId) {
		this.orgDwId = orgDwId;
	}

	@Column(name = "qr_code", length = 80)
	public String getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@Column(name = "bd_id", length = 40)
	public String getBdId() {
		return this.bdId;
	}

	public void setBdId(String bdId) {
		this.bdId = bdId;
	}

	@Column(name = "sb_zl", length = 40)
	public String getSbZl() {
		return this.sbZl;
	}

	public void setSbZl(String sbZl) {
		this.sbZl = sbZl;
	}

}