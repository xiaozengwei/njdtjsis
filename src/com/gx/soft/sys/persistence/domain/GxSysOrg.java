package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GxSysOrg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_sys_org")
public class GxSysOrg implements java.io.Serializable {

	// Fields

	private String rowId;
	private String orgName;
	private String orgShowName;
	private String orgEnName;
	private String orgIntro;
	private Timestamp createTime;
	private String createUserId;
	private Timestamp modifyTime;
	private String modifyUserId;
	private String dataStatus;
	private Long dataOrder;
	private String parentOrgId;
	private String parentOrgName;
	private String orgType;
	private String isMainPage;
	private String orgComId;
	private String isShow;// 是否显示

	// Constructors

	/** default constructor */
	public GxSysOrg() {
	}

	/** full constructor */
	public GxSysOrg(String orgName, String orgShowName, String orgEnName,
			String orgIntro, Timestamp createTime, String createUserId,
			Timestamp modifyTime, String modifyUserId, String dataStatus,
			Long dataOrder, String parentOrgId, String parentOrgName,
			String orgType, String isMainPage, String orgComId) {
		this.orgName = orgName;
		this.orgShowName = orgShowName;
		this.orgEnName = orgEnName;
		this.orgIntro = orgIntro;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.modifyTime = modifyTime;
		this.modifyUserId = modifyUserId;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.parentOrgId = parentOrgId;
		this.parentOrgName = parentOrgName;
		this.orgType = orgType;
		this.isMainPage = isMainPage;
		this.orgComId = orgComId;
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

	@Column(name = "org_name", length = 80)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(name = "org_show_name", length = 180)
	public String getOrgShowName() {
		return this.orgShowName;
	}

	public void setOrgShowName(String orgShowName) {
		this.orgShowName = orgShowName;
	}

	@Column(name = "org_en_name", length = 80)
	public String getOrgEnName() {
		return this.orgEnName;
	}

	public void setOrgEnName(String orgEnName) {
		this.orgEnName = orgEnName;
	}

	@Column(name = "org_intro", length = 40)
	public String getOrgIntro() {
		return this.orgIntro;
	}

	public void setOrgIntro(String orgIntro) {
		this.orgIntro = orgIntro;
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

	@Column(name = "parent_org_id", length = 40)
	public String getParentOrgId() {
		return this.parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	@Column(name = "parent_org_name", length = 80)
	public String getParentOrgName() {
		return this.parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}

	@Column(name = "org_type", length = 40)
	public String getOrgType() {
		return this.orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	@Column(name = "is_main_page", length = 40)
	public String getIsMainPage() {
		return this.isMainPage;
	}

	public void setIsMainPage(String isMainPage) {
		this.isMainPage = isMainPage;
	}

	@Column(name = "org_com_id", length = 40)
	public String getOrgComId() {
		return this.orgComId;
	}

	public void setOrgComId(String orgComId) {
		this.orgComId = orgComId;
	}

	@Column(name = "is_show", length = 1)
	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
}