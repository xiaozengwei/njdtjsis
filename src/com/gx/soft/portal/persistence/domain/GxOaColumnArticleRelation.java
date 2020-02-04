package com.gx.soft.portal.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaColumnArticleRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_column_article_relation")
public class GxOaColumnArticleRelation implements java.io.Serializable {

	// Fields

	private String rowId;
	private String columnId;
	private String atricleId;
	private Timestamp createTime;
	private String createUserId;
	private Integer orderNum;

	// Constructors

	/** default constructor */
	public GxOaColumnArticleRelation() {
	}

	/** full constructor */
	public GxOaColumnArticleRelation(String columnId, String atricleId,
			Timestamp createTime, String createUserId, Integer orderNum) {
		this.columnId = columnId;
		this.atricleId = atricleId;
		this.createTime = createTime;
		this.createUserId = createUserId;
		this.orderNum = orderNum;
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

	@Column(name = "column_id", length = 32)
	public String getColumnId() {
		return this.columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}

	@Column(name = "atricle_id", length = 32)
	public String getAtricleId() {
		return this.atricleId;
	}

	public void setAtricleId(String atricleId) {
		this.atricleId = atricleId;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "create_user_id", length = 32)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "order_num")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

}