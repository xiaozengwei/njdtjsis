package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GxSysFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_sys_function")
public class GxSysFunction implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long rowId;
	private String functionName;
	private String functionShowName;
	private String functionEnName;
	private String functionIntro;
	private Timestamp createTime;
	private String createUserId;
	private Timestamp modifyTime;
	private String modifyUserId;
	private String dataStatus;
	private Long dataOrder;
	private String parentFunctionId;
	private String parentFunctionName;
	private String functionType;
	private String isMainPage;
	private String functionIcon;
	private String mainPageIcon;
	private String mainFunctionName;
	private Integer mainOrder;

	// Constructors

	/** default constructor */
	public GxSysFunction() {
	}

	/** minimal constructor */
	public GxSysFunction(Long rowId, String functionName) {
		this.rowId = rowId;
		this.functionName = functionName;
	}

	/** full constructor */
	public GxSysFunction(Long rowId, String functionName,
			String functionShowName, String functionEnName,
			String functionIntro, Timestamp createTime, String createUserId,
			Timestamp modifyTime, String modifyUserId, String dataStatus,
			Long dataOrder, String parentFunctionId, String parentFunctionName,
			String functionType, String isMainPage, String functionIcon,
			String mainPageIcon, String mainFunctionName, Integer mainOrder) {
		this.rowId = rowId;
		this.functionName = functionName;
		this.functionShowName = functionShowName;
		this.functionEnName = functionEnName;
		this.functionIntro = functionIntro;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.modifyTime = modifyTime;
		this.modifyUserId = modifyUserId;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.parentFunctionId = parentFunctionId;
		this.parentFunctionName = parentFunctionName;
		this.functionType = functionType;
		this.isMainPage = isMainPage;
		this.functionIcon = functionIcon;
		this.mainPageIcon = mainPageIcon;
		this.mainFunctionName = mainFunctionName;
		this.mainOrder = mainOrder;
	}

	// Property accessors
	@Id
	@Column(name = "row_id", unique = true, nullable = false)
	public Long getRowId() {
		return this.rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	@Column(name = "function_name", nullable = false, length = 80)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "function_show_name", length = 180)
	public String getFunctionShowName() {
		return this.functionShowName;
	}

	public void setFunctionShowName(String functionShowName) {
		this.functionShowName = functionShowName;
	}

	@Column(name = "function_en_name", length = 80)
	public String getFunctionEnName() {
		return this.functionEnName;
	}

	public void setFunctionEnName(String functionEnName) {
		this.functionEnName = functionEnName;
	}

	@Column(name = "function_intro", length = 40)
	public String getFunctionIntro() {
		return this.functionIntro;
	}

	public void setFunctionIntro(String functionIntro) {
		this.functionIntro = functionIntro;
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

	@Column(name = "modify_time", length = 19)
	public Timestamp getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "modify_user_id", length = 40)
	public String getModifyUserId() {
		return this.modifyUserId;
	}

	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	@Column(name = "data_status", length = 40)
	public String getDataStatus() {
		return this.dataStatus;
	}

	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	@Column(name = "data_order")
	public Long getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(Long dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "parent_function_id", length = 40)
	public String getParentFunctionId() {
		return this.parentFunctionId;
	}

	public void setParentFunctionId(String parentFunctionId) {
		this.parentFunctionId = parentFunctionId;
	}

	@Column(name = "parent_function_name", length = 80)
	public String getParentFunctionName() {
		return this.parentFunctionName;
	}

	public void setParentFunctionName(String parentFunctionName) {
		this.parentFunctionName = parentFunctionName;
	}

	@Column(name = "function_type", length = 40)
	public String getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	@Column(name = "is_main_page", length = 40)
	public String getIsMainPage() {
		return this.isMainPage;
	}

	public void setIsMainPage(String isMainPage) {
		this.isMainPage = isMainPage;
	}

	@Column(name = "function_icon", length = 80)
	public String getFunctionIcon() {
		return this.functionIcon;
	}

	public void setFunctionIcon(String functionIcon) {
		this.functionIcon = functionIcon;
	}

	@Column(name = "main_page_icon", length = 40)
	public String getMainPageIcon() {
		return this.mainPageIcon;
	}

	public void setMainPageIcon(String mainPageIcon) {
		this.mainPageIcon = mainPageIcon;
	}

	@Column(name = "main_function_name", length = 80)
	public String getMainFunctionName() {
		return this.mainFunctionName;
	}

	public void setMainFunctionName(String mainFunctionName) {
		this.mainFunctionName = mainFunctionName;
	}

	@Column(name = "main_order")
	public Integer getMainOrder() {
		return this.mainOrder;
	}

	public void setMainOrder(Integer mainOrder) {
		this.mainOrder = mainOrder;
	}

}