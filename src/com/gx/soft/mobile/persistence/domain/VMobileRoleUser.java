package com.gx.soft.mobile.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VMobileRoleUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_mobile_role_user")
public class VMobileRoleUser implements java.io.Serializable {

	// Fields

	private String VMobileRoleUserKey;
	private String userKey;
	private String userName;
	private String userShowName;
	private String userEnName;
	private String userId;
	private String dataStatus;
	private Long dataOrder;
	private String userSex;
	private String userType;
	private String roleKey;
	private String roleName;
	private String roleId;
	private String roleIntro;
	private Long RDataOrder;

	// Constructors
	@Id
	@Column(name = "v_mobile_role_user_key", length = 81)
	public String getVMobileRoleUserKey() {
		return this.VMobileRoleUserKey;
	}

	public void setVMobileRoleUserKey(String VMobileRoleUserKey) {
		this.VMobileRoleUserKey = VMobileRoleUserKey;
	}

	@Column(name = "user_key", nullable = false, length = 40)
	public String getUserKey() {
		return this.userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	@Column(name = "user_name", length = 80)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_show_name", length = 180)
	public String getUserShowName() {
		return this.userShowName;
	}

	public void setUserShowName(String userShowName) {
		this.userShowName = userShowName;
	}

	@Column(name = "user_en_name", length = 80)
	public String getUserEnName() {
		return this.userEnName;
	}

	public void setUserEnName(String userEnName) {
		this.userEnName = userEnName;
	}

	@Column(name = "user_id", length = 40)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	@Column(name = "user_sex", length = 80)
	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Column(name = "user_type", length = 40)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "role_key", nullable = false, length = 40)
	public String getRoleKey() {
		return this.roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
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

	@Column(name = "r_data_order")
	public Long getRDataOrder() {
		return this.RDataOrder;
	}

	public void setRDataOrder(Long RDataOrder) {
		this.RDataOrder = RDataOrder;
	}

}