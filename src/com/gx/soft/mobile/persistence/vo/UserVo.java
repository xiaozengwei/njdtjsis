package com.gx.soft.mobile.persistence.vo;

/**
 * 用户信息vo
 * 
 * @author YING
 * @date 2016-1-4
 */
public class UserVo {
	private String username;
	private String userId;
	private String appkey;
	private String orgName;
	private String orgId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
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

	public UserVo(String username, String userId, String appkey,
			String orgName, String orgId) {
		super();
		this.username = username;
		this.userId = userId;
		this.appkey = appkey;
		this.orgName = orgName;
		this.orgId = orgId;
	}

	public UserVo(String username, String userId, String orgName, String orgId) {
		super();
		this.username = username;
		this.userId = userId;
		this.orgName = orgName;
		this.orgId = orgId;
	}

	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
