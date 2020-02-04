package com.gx.soft.sys.persistence.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * GxOaWenhaoConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gx_oa_wenhao_config")
public class GxOaWenhaoConfig implements java.io.Serializable {

	// Fields

	private String wenhaoRowId;
	private String deptId;//单位ID
	private String wenhaoYear;//文号年份
	private String wenhaoType;//文号类型
	private String bracketType;//括号类型
	private String markWord;//号字
	private String completeContent;//完整内容
	private Integer currentMaxValue;//当前最大值
	private Timestamp createTime;//创建时间
	private String creatorId;//创建者ID
	private String creatorName;//创建者名字
	private String docType;//文档类型
	private String maxWenhaoRowId;//文号对应max 表 rowid
	private Integer orderNum;//排序

	// Constructors

	/** default constructor */
	public GxOaWenhaoConfig() {
	}

	/** full constructor */
	public GxOaWenhaoConfig(String deptId, String wenhaoYear,
			String wenhaoType, String bracketType, String markWord,
			String completeContent, Integer currentMaxValue,
			Timestamp createTime, String creatorId, String creatorName,
			String docType, String maxWenhaoRowId, Integer orderNum) {
		this.deptId = deptId;
		this.wenhaoYear = wenhaoYear;
		this.wenhaoType = wenhaoType;
		this.bracketType = bracketType;
		this.markWord = markWord;
		this.completeContent = completeContent;
		this.currentMaxValue = currentMaxValue;
		this.createTime = createTime;
		this.creatorId = creatorId;
		this.creatorName = creatorName;
		this.docType = docType;
		this.maxWenhaoRowId = maxWenhaoRowId;
		this.orderNum = orderNum;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "wenhao_row_id", unique = true, nullable = false, length = 50)
	public String getWenhaoRowId() {
		return this.wenhaoRowId;
	}

	public void setWenhaoRowId(String wenhaoRowId) {
		this.wenhaoRowId = wenhaoRowId;
	}

	@Column(name = "dept_id", length = 50)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "wenhao_year", length = 4)
	public String getWenhaoYear() {
		return this.wenhaoYear;
	}

	public void setWenhaoYear(String wenhaoYear) {
		this.wenhaoYear = wenhaoYear;
	}

	@Column(name = "wenhao_type", length = 100)
	public String getWenhaoType() {
		return this.wenhaoType;
	}

	public void setWenhaoType(String wenhaoType) {
		this.wenhaoType = wenhaoType;
	}

	@Column(name = "bracket_type", length = 10)
	public String getBracketType() {
		return this.bracketType;
	}

	public void setBracketType(String bracketType) {
		this.bracketType = bracketType;
	}

	@Column(name = "mark_word", length = 50)
	public String getMarkWord() {
		return this.markWord;
	}

	public void setMarkWord(String markWord) {
		this.markWord = markWord;
	}

	@Column(name = "complete_content", length = 30)
	public String getCompleteContent() {
		return this.completeContent;
	}

	public void setCompleteContent(String completeContent) {
		this.completeContent = completeContent;
	}

	@Column(name = "current_max_value")
	public Integer getCurrentMaxValue() {
		return this.currentMaxValue;
	}

	public void setCurrentMaxValue(Integer currentMaxValue) {
		this.currentMaxValue = currentMaxValue;
	}

	@Column(name = "create_time", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "creator_id", length = 50)
	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	@Column(name = "creator_name", length = 100)
	public String getCreatorName() {
		return this.creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	@Column(name = "doc_type", length = 40)
	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Column(name = "max_wenhao_row_id", length = 50)
	public String getMaxWenhaoRowId() {
		return this.maxWenhaoRowId;
	}

	public void setMaxWenhaoRowId(String maxWenhaoRowId) {
		this.maxWenhaoRowId = maxWenhaoRowId;
	}

	@Column(name = "ORDER_Num")
	public Integer getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

}