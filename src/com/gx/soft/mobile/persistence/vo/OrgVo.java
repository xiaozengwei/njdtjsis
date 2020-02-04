package com.gx.soft.mobile.persistence.vo;

public class OrgVo {
	private String orgId;
	private String orgName;
	private String orgPId;
	private String orgPName;
	private String orgType;

	public OrgVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrgVo(String orgId, String orgName, String orgPId, String orgPName,
			String orgType) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.orgPId = orgPId;
		this.orgPName = orgPName;
		this.orgType = orgType;
	}

	public String getOrgPName() {
		return orgPName;
	}

	public void setOrgPName(String orgPName) {
		this.orgPName = orgPName;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgPId() {
		return orgPId;
	}

	public void setOrgPId(String orgPId) {
		this.orgPId = orgPId;
	}

}
