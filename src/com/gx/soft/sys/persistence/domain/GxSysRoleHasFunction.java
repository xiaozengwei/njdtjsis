package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GxSysRoleHasFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_sys_role_has_function")
public class GxSysRoleHasFunction implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowId;
	private Long functionId;
	private String roleId;
	private Timestamp createTime;
	private String createUserId;
	private String dataStatus;
	private Long dataOrder;
	private String rlType;

	// Constructors

	/** default constructor */
	public GxSysRoleHasFunction() {
	}

	/** minimal constructor */
	public GxSysRoleHasFunction(String rowId, Long functionId, String roleId) {
		this.rowId = rowId;
		this.functionId = functionId;
		this.roleId = roleId;
	}

	/** full constructor */
	public GxSysRoleHasFunction(String rowId, Long functionId, String roleId,
			Timestamp createTime, String createUserId, String dataStatus,
			Long dataOrder, String rlType) {
		this.rowId = rowId;
		this.functionId = functionId;
		this.roleId = roleId;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.dataStatus = dataStatus;
		this.dataOrder = dataOrder;
		this.rlType = rlType;
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

	@Column(name = "function_id", nullable = false)
	public Long getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}

	@Column(name = "role_id", nullable = false, length = 80)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
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

	@Column(name = "rl_type", length = 40)
	public String getRlType() {
		return this.rlType;
	}

	public void setRlType(String rlType) {
		this.rlType = rlType;
	}

}