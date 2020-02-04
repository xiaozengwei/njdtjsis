package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VRoleUserId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "v_role_user")
public class VRoleUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String VRoleUserKey;
	private String userKey;
	private String userName;
	private String userShowName;
	private String userEnName;
	private String userId;
	private Timestamp createTime;
	private String createUserId;
	private Timestamp modifyTime;
	private String modifyUserId;
	private String dataStatus;
	private Long dataOrder;
	private String userMobileNum;
	private String userSex;
	private String userType;
	private String roleKey;
	private String roleName;
	private String roleId;
	private String roleIntro;
	private Timestamp RCreateTime;
	private String RCreateUserId;
	private Timestamp RModifyTime;
	private String RModifyUserId;
	private String RDataStatus;
	private Long RDataOrder;
	private String parentRoleId;
	private String parentRoleName;
	private String roleType;
	private String rlType;
	private String rhuId;// role has user id

	// Constructors

	/** default constructor */
	public VRoleUser() {
	}

	/** minimal constructor */
	public VRoleUser(String VRoleUserKey) {
		this.VRoleUserKey = VRoleUserKey;
	}

	/** full constructor */
	public VRoleUser(String VRoleUserKey, String userKey, String userName,
			String userShowName, String userEnName, String userId,
			Timestamp createTime, String createUserId, Timestamp modifyTime,
			String modifyUserId, String dataStatus, Long dataOrder,
			String userMobileNum, String userSex, String userType,
			String roleKey, String roleName, String roleId, String roleIntro,
			Timestamp RCreateTime, String RCreateUserId, Timestamp RModifyTime,
			String RModifyUserId, String RDataStatus, Long RDataOrder,
			String parentRoleId, String parentRoleName, String roleType,
			String rlType, String rhuId) {
		this.VRoleUserKey = VRoleUserKey;
		this.userKey = userKey;
		this.userName = userName;
		this.userShowName = userShowName;
		this.userEnName = userEnName;
		this.userId = userId;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.modifyTime = modifyTime;
		this.modifyUserId = modifyUserId;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.userMobileNum = userMobileNum;
		this.userSex = userSex;
		this.userType = userType;
		this.roleKey = roleKey;
		this.roleName = roleName;
		this.roleId = roleId;
		this.roleIntro = roleIntro;
		this.RCreateTime = RCreateTime;
		this.RCreateUserId = RCreateUserId;
		this.RModifyTime = RModifyTime;
		this.RModifyUserId = RModifyUserId;
		this.RDataStatus = RDataStatus;
		this.RDataOrder = RDataOrder;
		this.parentRoleId = parentRoleId;
		this.parentRoleName = parentRoleName;
		this.roleType = roleType;
		this.rlType = rlType;
		this.rhuId = rhuId;
	}

	@Id
	@Column(name = "v_role_user_key", length = 120, unique = true, nullable = false)
	public String getVRoleUserKey() {
		return this.VRoleUserKey;
	}

	public void setVRoleUserKey(String VRoleUserKey) {
		this.VRoleUserKey = VRoleUserKey;
	}

	@Column(name = "user_key", length = 40)
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

	@Column(name = "user_mobile_num", length = 40)
	public String getUserMobileNum() {
		return this.userMobileNum;
	}

	public void setUserMobileNum(String userMobileNum) {
		this.userMobileNum = userMobileNum;
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

	@Column(name = "role_key", length = 40)
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

	@Column(name = "r_create_time", length = 19)
	public Timestamp getRCreateTime() {
		return this.RCreateTime;
	}

	public void setRCreateTime(Timestamp RCreateTime) {
		this.RCreateTime = RCreateTime;
	}

	@Column(name = "r_create_user_id", length = 40)
	public String getRCreateUserId() {
		return this.RCreateUserId;
	}

	public void setRCreateUserId(String RCreateUserId) {
		this.RCreateUserId = RCreateUserId;
	}

	@Column(name = "r_modify_time", length = 19)
	public Timestamp getRModifyTime() {
		return this.RModifyTime;
	}

	public void setRModifyTime(Timestamp RModifyTime) {
		this.RModifyTime = RModifyTime;
	}

	@Column(name = "r_modify_user_id", length = 40)
	public String getRModifyUserId() {
		return this.RModifyUserId;
	}

	public void setRModifyUserId(String RModifyUserId) {
		this.RModifyUserId = RModifyUserId;
	}

	@Column(name = "r_data_status", length = 40)
	public String getRDataStatus() {
		return this.RDataStatus;
	}

	public void setRDataStatus(String RDataStatus) {
		this.RDataStatus = RDataStatus;
	}

	@Column(name = "r_data_order")
	public Long getRDataOrder() {
		return this.RDataOrder;
	}

	public void setRDataOrder(Long RDataOrder) {
		this.RDataOrder = RDataOrder;
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

	@Column(name = "rl_type", length = 40)
	public String getRlType() {
		return this.rlType;
	}

	public void setRlType(String rlType) {
		this.rlType = rlType;
	}

	@Column(name = "rhu_id", length = 40)
	public String getRhuId() {
		return rhuId;
	}

	public void setRhuId(String rhuId) {
		this.rhuId = rhuId;
	}

}