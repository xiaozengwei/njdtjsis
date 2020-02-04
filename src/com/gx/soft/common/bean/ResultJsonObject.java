package com.gx.soft.common.bean;

/**
 * 返回的json实体
 * 
 * @author YING
 * @date 2015-6-18
 */
public class ResultJsonObject {

	private String statusCode = "200";
	private String message;
	private String tabid;
	private boolean closeCurrent = true;
	private String forward;
	private String forwardConfirm;

	public ResultJsonObject(String statusCode, String message, String tabid,
			boolean closeCurrent, String forward, String forwardConfirm) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.tabid = tabid;
		this.closeCurrent = closeCurrent;
		this.forward = forward;
		this.forwardConfirm = forwardConfirm;
	}

	public ResultJsonObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTabid() {
		return tabid;
	}

	public void setTabid(String tabid) {
		this.tabid = tabid;
	}

	public boolean getCloseCurrent() {
		return closeCurrent;
	}

	public void setCloseCurrent(boolean closeCurrent) {
		this.closeCurrent = closeCurrent;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getForwardConfirm() {
		return forwardConfirm;
	}

	public void setForwardConfirm(String forwardConfirm) {
		this.forwardConfirm = forwardConfirm;
	}

}
