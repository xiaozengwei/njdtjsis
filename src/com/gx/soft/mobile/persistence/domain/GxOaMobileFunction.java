package com.gx.soft.mobile.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GxOaMobileFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_mobile_function")
public class GxOaMobileFunction implements java.io.Serializable {

	// Fields

	private String functionId;
	private String functionName;
	private String functionType;
	private String functionFragment;
	private String isVisible;
	private Integer orderNum;
	private String functionImg;
	private String functionActivity;
	private String functionUrl;
	private String delFlag;

	// Constructors

	/** default constructor */
	public GxOaMobileFunction() {
	}

	/** minimal constructor */
	public GxOaMobileFunction(String functionId) {
		this.functionId = functionId;
	}

	/** full constructor */
	public GxOaMobileFunction(String functionId, String functionName,
			String functionType, String functionFragment, String isVisible,
			Integer orderNum, String functionImg, String functionActivity,
			String functionUrl, String delFlag) {
		this.functionId = functionId;
		this.functionName = functionName;
		this.functionType = functionType;
		this.functionFragment = functionFragment;
		this.isVisible = isVisible;
		this.orderNum = orderNum;
		this.functionImg = functionImg;
		this.functionActivity = functionActivity;
		this.functionUrl = functionUrl;
		this.delFlag = delFlag;
	}

	// Property accessors
	@Id
	@Column(name = "function_id", unique = true, nullable = false, length = 40)
	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	@Column(name = "function_name", length = 40)
	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Column(name = "function_type", length = 1)
	public String getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	@Column(name = "function_fragment", length = 1)
	public String getFunctionFragment() {
		return this.functionFragment;
	}

	public void setFunctionFragment(String functionFragment) {
		this.functionFragment = functionFragment;
	}

	@Column(name = "is_visible", length = 1)
	public String getIsVisible() {
		return this.isVisible;
	}

	public void setIsVisible(String isVisible) {
		this.isVisible = isVisible;
	}

	@Column(name = "order_num")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "function_img", length = 200)
	public String getFunctionImg() {
		return this.functionImg;
	}

	public void setFunctionImg(String functionImg) {
		this.functionImg = functionImg;
	}

	@Column(name = "function_activity", length = 200)
	public String getFunctionActivity() {
		return this.functionActivity;
	}

	public void setFunctionActivity(String functionActivity) {
		this.functionActivity = functionActivity;
	}

	@Column(name = "function_url", length = 300)
	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	@Column(name = "del_flag", length = 1)
	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}