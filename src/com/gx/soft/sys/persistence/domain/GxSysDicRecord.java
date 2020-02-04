package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GxSysDicRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_sys_dic_record")
public class GxSysDicRecord implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowId;
	private Timestamp createDate;
	private String createUserId;
	private String dicName;
	private String dicId;
	private String dicShowVal;
	private String dicValue;
	private String dicType;
	private String status;
	private Timestamp updateTime;
	private Long orderNum;
	private String dicFunction;
	private String tableId;
	private String parentId;
	private String parentName;
	private String flagZm;
	private String flagRq;
	private String flagNum;
	private String flagWrite;
	private String maxStatus;
	private String maxId;

	// Constructors

	/** default constructor */
	public GxSysDicRecord() {
	}

	/** minimal constructor */
	public GxSysDicRecord(String rowId) {
		this.rowId = rowId;
	}

	public GxSysDicRecord(Timestamp createDate, String createUserId,
			String dicName, String dicId, String dicShowVal, String dicValue,
			String dicType, String status, Timestamp updateTime, Long orderNum,
			String dicFunction, String tableId, String parentId,
			String parentName, String flagZm, String flagRq, String flagNum,
			String flagWrite, String maxStatus, String maxId) {
		super();
		this.createDate = createDate;
		this.createUserId = createUserId;
		this.dicName = dicName;
		this.dicId = dicId;
		this.dicShowVal = dicShowVal;
		this.dicValue = dicValue;
		this.dicType = dicType;
		this.status = status;
		this.updateTime = updateTime;
		this.orderNum = orderNum;
		this.dicFunction = dicFunction;
		this.tableId = tableId;
		this.parentId = parentId;
		this.parentName = parentName;
		this.flagZm = flagZm;
		this.flagRq = flagRq;
		this.flagNum = flagNum;
		this.flagWrite = flagWrite;
		this.maxStatus = maxStatus;
		this.maxId = maxId;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ROW_ID", unique = true, nullable = false, length = 40)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "CREATE_DATE", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_USER_ID", length = 40)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "DIC_NAME", length = 40)
	public String getDicName() {
		return this.dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	@Column(name = "DIC_ID", length = 40)
	public String getDicId() {
		return this.dicId;
	}

	public void setDicId(String dicId) {
		this.dicId = dicId;
	}

	@Column(name = "DIC_SHOW_VAL", length = 100)
	public String getDicShowVal() {
		return this.dicShowVal;
	}

	public void setDicShowVal(String dicShowVal) {
		this.dicShowVal = dicShowVal;
	}

	@Column(name = "DIC_VALUE", length = 100)
	public String getDicValue() {
		return this.dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	@Column(name = "DIC_TYPE", length = 100)
	public String getDicType() {
		return this.dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "UPDATE_TIME", length = 19)
	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "ORDER_NUM")
	public Long getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "DIC_FUNCTION", length = 10)
	public String getDicFunction() {
		return this.dicFunction;
	}

	public void setDicFunction(String dicFunction) {
		this.dicFunction = dicFunction;
	}

	@Column(name = "TABLE_ID", length = 32)
	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	@Column(name = "PARENT_ID", length = 40)
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "PARENT_NAME", length = 40)
	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name = "FLAG_ZM", length = 40)
	public String getFlagZm() {
		return this.flagZm;
	}

	public void setFlagZm(String flagZm) {
		this.flagZm = flagZm;
	}

	@Column(name = "FLAG_RQ", length = 40)
	public String getFlagRq() {
		return this.flagRq;
	}

	public void setFlagRq(String flagRq) {
		this.flagRq = flagRq;
	}

	@Column(name = "FLAG_NUM", length = 40)
	public String getFlagNum() {
		return this.flagNum;
	}

	public void setFlagNum(String flagNum) {
		this.flagNum = flagNum;
	}

	@Column(name = "FLAG_WRITE", length = 40)
	public String getFlagWrite() {
		return this.flagWrite;
	}

	public void setFlagWrite(String flagWrite) {
		this.flagWrite = flagWrite;
	}

	@Column(name = "max_status", length = 40)
	public String getMaxStatus() {
		return maxStatus;
	}

	public void setMaxStatus(String maxStatus) {
		this.maxStatus = maxStatus;
	}

	@Column(name = "max_id", length = 40)
	public String getMaxId() {
		return maxId;
	}

	public void setMaxId(String maxId) {
		this.maxId = maxId;
	}

}