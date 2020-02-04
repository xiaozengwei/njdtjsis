package com.gx.soft.sys.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VSysDic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_sys_dic")
public class VSysDic implements java.io.Serializable {

	private String VSysDicKey;
	private String indexDicName;
	private String indexDicId;
	private String indexDicDesc;
	private String recordDicName;
	private String recordDicId;
	private String dicShowVal;
	private String dicValue;
	private String dicType;
	private Long orderNum;
	private String maxStatus;
	private String maxId;

	// Constructors


	// Property accessors
	@Id
	@Column(name = "v_sys_dic_key", length = 81)
	public String getVSysDicKey() {
		return this.VSysDicKey;
	}

	public void setVSysDicKey(String VSysDicKey) {
		this.VSysDicKey = VSysDicKey;
	}

	@Column(name = "index_dic_name", length = 80)
	public String getIndexDicName() {
		return this.indexDicName;
	}

	public void setIndexDicName(String indexDicName) {
		this.indexDicName = indexDicName;
	}

	@Column(name = "index_dic_id", length = 40)
	public String getIndexDicId() {
		return this.indexDicId;
	}

	public void setIndexDicId(String indexDicId) {
		this.indexDicId = indexDicId;
	}

	@Column(name = "index_dic_desc", length = 220)
	public String getIndexDicDesc() {
		return this.indexDicDesc;
	}

	public void setIndexDicDesc(String indexDicDesc) {
		this.indexDicDesc = indexDicDesc;
	}

	@Column(name = "record_dic_name", length = 40)
	public String getRecordDicName() {
		return this.recordDicName;
	}

	public void setRecordDicName(String recordDicName) {
		this.recordDicName = recordDicName;
	}

	@Column(name = "record_dic_id", length = 40)
	public String getRecordDicId() {
		return this.recordDicId;
	}

	public void setRecordDicId(String recordDicId) {
		this.recordDicId = recordDicId;
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

	@Column(name = "ORDER_NUM")
	public Long getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
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