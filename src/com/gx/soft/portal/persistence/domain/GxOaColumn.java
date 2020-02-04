package com.gx.soft.portal.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaColumn entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_column")
public class GxOaColumn implements java.io.Serializable {

	// Fields

	private String rowId;
	private String columnName;//栏目名称
	private String columnType;//栏目类型
	private String columnInfo;//栏目介绍
	private Integer orderNum;//排序
	private String parentId;//父ID
	private String parentName;//父名称
	private String columnIcon;//图标
	private String createUserId;//创建人
	private String createUserName;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public GxOaColumn() {
	}

	/** full constructor */
	public GxOaColumn(String columnName, String columnType, String columnInfo,
			Integer orderNum, String parentId, String columnIcon,
			String createUserId, String createUserName, Timestamp createTime) {
		this.columnName = columnName;
		this.columnType = columnType;
		this.columnInfo = columnInfo;
		this.orderNum = orderNum;
		this.parentId = parentId;
		this.columnIcon = columnIcon;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createTime = createTime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "row_id", unique = true, nullable = false, length = 32)
	public String getRowId() {
		return this.rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@Column(name = "column_name", length = 200)
	public String getColumnName() {
		return this.columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Column(name = "column_type", length = 10)
	public String getColumnType() {
		return this.columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	@Column(name = "column_info", length = 200)
	public String getColumnInfo() {
		return this.columnInfo;
	}

	public void setColumnInfo(String columnInfo) {
		this.columnInfo = columnInfo;
	}

	@Column(name = "order_num")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name = "column_icon", length = 50)
	public String getColumnIcon() {
		return this.columnIcon;
	}

	public void setColumnIcon(String columnIcon) {
		this.columnIcon = columnIcon;
	}

	@Column(name = "parent_name", length = 500)
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	@Column(name = "parent_id", length = 32)
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "create_user_id", length = 32)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "create_user_name", length = 50)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}