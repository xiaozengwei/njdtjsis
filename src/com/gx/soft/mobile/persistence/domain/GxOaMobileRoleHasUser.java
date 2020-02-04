package com.gx.soft.mobile.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * GxOaMobileRoleHasUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_mobile_role_has_user")
public class GxOaMobileRoleHasUser implements java.io.Serializable {

	// Fields

	private GxOaMobileRoleHasUserId id;
	private Integer orderNum;
	private Timestamp createTime;
	private String status;
	private String createUserId;

	// Constructors

	/** default constructor */
	public GxOaMobileRoleHasUser() {
	}

	/** minimal constructor */
	public GxOaMobileRoleHasUser(GxOaMobileRoleHasUserId id) {
		this.id = id;
	}

	/** full constructor */
	public GxOaMobileRoleHasUser(GxOaMobileRoleHasUserId id, Integer orderNum,
			Timestamp createTime, String status, String createUserId) {
		this.id = id;
		this.orderNum = orderNum;
		this.createTime = createTime;
		this.status = status;
		this.createUserId = createUserId;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, length = 40)),
			@AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false, length = 40)) })
	public GxOaMobileRoleHasUserId getId() {
		return this.id;
	}

	public void setId(GxOaMobileRoleHasUserId id) {
		this.id = id;
	}

	@Column(name = "order_num")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "status", length = 40)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "create_user_id", length = 20)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

}