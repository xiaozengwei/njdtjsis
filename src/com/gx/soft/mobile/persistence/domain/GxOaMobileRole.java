package com.gx.soft.mobile.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaMobileRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_mobile_role")
public class GxOaMobileRole implements java.io.Serializable {

	// Fields

	private String rowId;
	private String roleName;
	private String roleId;
	private String roleIntro;
	private Timestamp createTime;
	private String createUserId;
	private Timestamp modifyTime;
	private String modifyUserId;
	private String dataStatus;
	private Long dataOrder;
	private String parentRoleId;
	private String parentRoleName;
	private String roleType;

	// Constructors

	/** default constructor */
	public GxOaMobileRole() {
	}

	/** full constructor */
	public GxOaMobileRole(String roleName, String roleId, String roleIntro,
			Timestamp createTime, String createUserId, Timestamp modifyTime,
			String modifyUserId, String dataStatus, Long dataOrder,
			String parentRoleId, String parentRoleName, String roleType) {
		this.roleName = roleName;
		this.roleId = roleId;
		this.roleIntro = roleIntro;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.modifyTime = modifyTime;
		this.modifyUserId = modifyUserId;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.parentRoleId = parentRoleId;
		this.parentRoleName = parentRoleName;
		this.roleType = roleType;
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

	@Column(name = "role_name", length = 80)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_id", length = 80)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_intro", length = 40)
	public String getRoleIntro() {
		return this.roleIntro;
	}

	public void setRoleIntro(String roleIntro) {
		this.roleIntro = roleIntro;
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

	@Column(name = "parent_role_id", length = 40)
	public String getParentRoleId() {
		return this.parentRoleId;
	}

	public void setParentRoleId(String parentRoleId) {
		this.parentRoleId = parentRoleId;
	}

	@Column(name = "parent_role_name", length = 80)
	public String getParentRoleName() {
		return this.parentRoleName;
	}

	public void setParentRoleName(String parentRoleName) {
		this.parentRoleName = parentRoleName;
	}

	@Column(name = "role_type", length = 40)
	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

}