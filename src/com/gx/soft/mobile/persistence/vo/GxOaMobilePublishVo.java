package com.gx.soft.mobile.persistence.vo;

import java.sql.Timestamp;

/**
 * 手机端发布信息实体类
 * 
 * @author YING
 * @date 2016-1-5
 */
public class GxOaMobilePublishVo implements java.io.Serializable {

	// Fields

	private String appName;
	private String appEnName;
	private String appVer;
	private String appShowVer;
	private Timestamp publishDate;
	private String publishUser;

	// Constructors

	/** full constructor */
	public GxOaMobilePublishVo(String appName, String appEnName, String appVer,
			String appShowVer, Timestamp publishDate, String publishUser) {
		this.appName = appName;
		this.appEnName = appEnName;
		this.appVer = appVer;
		this.appShowVer = appShowVer;
		this.publishDate = publishDate;
		this.publishUser = publishUser;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppEnName() {
		return appEnName;
	}

	public void setAppEnName(String appEnName) {
		this.appEnName = appEnName;
	}

	public String getAppVer() {
		return appVer;
	}

	public void setAppVer(String appVer) {
		this.appVer = appVer;
	}

	public String getAppShowVer() {
		return appShowVer;
	}

	public void setAppShowVer(String appShowVer) {
		this.appShowVer = appShowVer;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public String getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(String publishUser) {
		this.publishUser = publishUser;
	}

}