package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GxSysDicIndex entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_sys_dic_index")
public class GxSysDicIndex implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowId;
	private Timestamp createDate;//创建时间
	private String createUserId;//创建人ID
	private String dicFunctionName;//字典名称
	private String dicFunctionId;//字典功能ID
	private String dicFunctionDec;//字典显示内容
	private String dicFunctionType;//字典类型
	private String status;//字典状态
	private Timestamp updateTime;//最后更新时间
	private Long orderNum;//排序

	// Constructors

	/** default constructor */
	public GxSysDicIndex() {
	}

	/** minimal constructor */
	public GxSysDicIndex(String rowId) {
		this.rowId = rowId;
	}

	/** full constructor */
	public GxSysDicIndex(String rowId, Timestamp createDate,
			String createUserId, String dicFunctionName, String dicFunctionId,
			String dicFunctionDec, String dicFunctionType, String status,
			Timestamp updateTime, Long orderNum) {
		this.rowId = rowId;
		this.createDate = createDate;
		this.createUserId = createUserId;
		this.dicFunctionName = dicFunctionName;
		this.dicFunctionId = dicFunctionId;
		this.dicFunctionDec = dicFunctionDec;
		this.dicFunctionType = dicFunctionType;
		this.status = status;
		this.updateTime = updateTime;
		this.orderNum = orderNum;
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

	@Column(name = "DIC_FUNCTION_NAME", length = 80)
	public String getDicFunctionName() {
		return this.dicFunctionName;
	}

	public void setDicFunctionName(String dicFunctionName) {
		this.dicFunctionName = dicFunctionName;
	}

	@Column(name = "DIC_FUNCTION_ID", length = 40)
	public String getDicFunctionId() {
		return this.dicFunctionId;
	}

	public void setDicFunctionId(String dicFunctionId) {
		this.dicFunctionId = dicFunctionId;
	}

	@Column(name = "DIC_FUNCTION_DEC", length = 220)
	public String getDicFunctionDec() {
		return this.dicFunctionDec;
	}

	public void setDicFunctionDec(String dicFunctionDec) {
		this.dicFunctionDec = dicFunctionDec;
	}

	@Column(name = "DIC_FUNCTION_TYPE", length = 10)
	public String getDicFunctionType() {
		return this.dicFunctionType;
	}

	public void setDicFunctionType(String dicFunctionType) {
		this.dicFunctionType = dicFunctionType;
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

}