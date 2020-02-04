package com.gx.soft.sys.vo;

/**
 * Ztree 数据Vo
 * 
 * @author YING
 * @date 2015-8-17
 */
public class ZtreeData {
	private String id;
	private String pId;
	private String name;
	private String title;

	public ZtreeData(String id, String pId, String name, String title) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.title = title;
	}

	public ZtreeData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
