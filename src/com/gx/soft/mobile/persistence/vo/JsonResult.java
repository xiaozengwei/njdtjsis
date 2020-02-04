package com.gx.soft.mobile.persistence.vo;

/**
 * 返回JSON实体
 * 
 * @author YING
 * @date 2016-1-4
 */
public class JsonResult {
	private String statusCode;// 消息代码
	private Object entity;// 实体
	private String message;// 返回消息

	public JsonResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JsonResult(String statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public JsonResult(String statusCode, Object entity, String message) {
		super();
		this.statusCode = statusCode;
		this.entity = entity;
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
