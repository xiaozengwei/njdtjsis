package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * GxSysUserInOrg entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_sys_user_in_org")
public class GxSysUserInOrg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rowId;
	private String userId;
	private String orgId;
	private Timestamp createTime;
	private String createUserId;
	private String dataStatus;
	private Integer dataOrder;
	private String rlType;

	// Constructors

	/** default constructor */
	public GxSysUserInOrg() {
	}

	/** minimal constructor */
	public GxSysUserInOrg(String rowId, String userId, String orgId) {
		this.rowId = rowId;
		this.userId = userId;
		this.orgId = orgId;
	}

	/** full constructor */
	public GxSysUserInOrg(String rowId, String userId, String orgId,
			Timestamp createTime, String createUserId, String dataStatus,
			Integer dataOrder, String rlType) {
		this.rowId = rowId;
		this.userId = userId;
		this.orgId = orgId;
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

	@Column(name = "user_id", nullable = false, length = 80)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "org_id", nullable = false, length = 80)
	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
	public Integer getDataOrder() {
		return this.dataOrder;
	}

	public void setDataOrder(Integer dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Column(name = "rl_type", length = 40)
	public String getRlType() {
		return this.rlType;
	}

	public void setRlType(String rlType) {
		this.rlType = rlType;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj != null) {
			GxSysUserInOrg uio = (GxSysUserInOrg) obj;
			if (uio.getRowId().equals(this.getRowId())) {
				return true;
			}
		}
		return false;
	}
}