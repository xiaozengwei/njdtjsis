package com.gx.soft.mobile.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaMobileRoleHasFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_mobile_role_has_function")
public class GxOaMobileRoleHasFunction implements java.io.Serializable {

	// Fields

	private String rowId;
	private String functionId;
	private String roleId;
	private String functionName;
	private String roleName;

	// Constructors

	/** default constructor */
	public GxOaMobileRoleHasFunction() {
	}

	/** full constructor */
	public GxOaMobileRoleHasFunction(String functionId, String roleId,
			String functionName, String roleName) {
		this.functionId = functionId;
		this.roleId = roleId;
		this.functionName = functionName;
		this.roleName = roleName;
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

	@Column(name = "function_id", length = 40)
	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	@Column(name = "role_id", length = 40)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "function_name", length = 40)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "role_name", length = 40)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}